package com.scuthnweb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.scuthnweb.dao.impl.AdminDaoImpl;
import com.scuthnweb.dao.impl.CustomerDaoImpl;
import com.scuthnweb.dao.impl.EventDaoImpl;
import com.scuthnweb.dao.impl.Event_summaryDaoImpl;
import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.EventDao;
import com.scuthnweb.dao.interf.Event_summaryDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.domain.Event;
import com.scuthnweb.domain.Event_summary;
import com.scuthnweb.service.interf.ActModule;
import com.sun.xml.internal.messaging.saaj.soap.MessageImpl;

public class ActModuleImpl implements ActModule{
	
	private  CustomerDao customerDao;
	private  AdminDao    adminDao;
	private  EventDao    eventDao;
	private  Event_summaryDao event_summaryDao;
	private  MessageDao  messageDao;
	private  Pub_rec_messageDao pub_rec_messageDao;
	
	

	
	@Override
	//退出活动
	public boolean exitAct(int event_id, int event_customer) {
		
		this.event_summaryDao = new Event_summaryDaoImpl();
		
		//调用 Dao 方法
		//删除成功返回 true
		//否则返回 false
		return  this.event_summaryDao.deleteEvent_summary(event_id, event_customer);		
	}
	

	@Override
	//下线活动
	public boolean offLineAct(int event_id, int event_publisher) {
		
	    this.eventDao           = new EventDaoImpl();
	    this.messageDao         = new MessageDaoImpl();
	    this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
	    this.event_summaryDao   = new Event_summaryDaoImpl();
	    
	    //如果该活动不是该管理员发布的
	    //则返回 false
	    if( this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1)==null ) return false;
	    
	    //更新活动下线状态失败
	    //返回  false
	    if( this.eventDao.updateEvent(event_id, -1, null, null, null, null, -1, 1) == null)  return false;
	    else {
	    	 //获取该活动的信息
	    	 Event eventOffline = (Event)(this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1).get(0));
	    	 //获取所有参与该活动的用户表
	    	 List<Event_summary> event_summaryList = this.event_summaryDao.findEvent_summaryM(event_id, -1);
	    
	         for( int i=0; i < event_summaryList.size(); i++){
	        	 
	        	 //向参与该活动的用户发送活动下线的信息
	        	 this.messageDao.createMessage( message_id, "您参与的活动：" + eventOffline.getEvent_name() 
	        			                                                 + "( 活动id:"+ eventOffline.getEvent_id() 
	        			                                                 + ")已经下线，感谢您对该活动的大力支持，希望您能更多参与本站活动！");
	             
	        	 this.pub_rec_messageDao.createPub_rec_Message( event_summaryList.get(i).getEvent_customer(), event_publisher, message_id);
	             
	        	 //逐条删除 Event_summary 表中参与活动的信息
	        	 this.event_summaryDao.deleteEvent_summary(event_id, event_summaryList.get(i).getEvent_customer());
	         }
	         return true;
	    }
	}
	
	
	@Override
	public boolean onLineAct(int event_id, String event_name,
			                 String event_intro, Date event_time, Date event_endtime,
			                 int event_maxPeople, int event_publisher, int event_state) {
		
		this.eventDao  = new EventDaoImpl();
		
	    if(this.eventDao.createEvent(event_name, event_intro, event_time, event_endtime, event_maxPeople, event_publisher)==null)
		     return false ;
	    else return true;		
	}
	
    /**
     * P0: event_id
     */
	@Override
	public boolean takePartInAct(int event_id, int event_customer) {
		
		this.event_summaryDao  = new Event_summaryDaoImpl();
		
		if( this.event_summaryDao.createEvent_summary( event_id, event_customer) != null)
			  return true;
		else  return false;
	}
	
	
@Override
    public List<Event> checkAllAct( boolean isAdmin) {
	    
	    this.eventDao  = new EventDaoImpl();
	    
	    List<Event> et = new ArrayList<Event>();
	    
	    //如果当前为管理员
	    //则返回所有活动
	    //如果是普通用户或者游客
	    //则返回当前站内上线的活动
	    if( isAdmin )  et.addAll( this.eventDao.findEventM(-1, null, null, null, null, -1, -1, -1) );	    
	    else           et.addAll( this.eventDao.findEventM(-1, null, null, null, null, -1, -1,  0) ); 

	    return et;
    }


    @Override
    public List<Event> checkTakePartIn(int event_customer) {
	
	    this.event_summaryDao = new Event_summaryDaoImpl();
	    this.eventDao         = new EventDaoImpl();
	
        //通过用户 id 查找该用户参与的所有活动 id
	    List<Event_summary> etsy = this.event_summaryDao.findEvent_summaryM(-1, event_customer);
	
	    //通过该用户参与的所有活动 id 查找活动
	    List<Event> et = new  ArrayList<Event>();
	    for( int i=0; i<etsy.size(); i++)   et.addAll( this.eventDao.findEventM( etsy.get(i).getEvent_id(), null, null, null, null, -1, -1, -1));
	
	    return et;
     } 


     @Override
     public List<Event> checkPublish(int event_publisher) {
	    
    	 this.eventDao = new EventDaoImpl();
    	 
    	 //管理员通过 id 查看自己发布的活动
    	 List<Event> publishEventList = this.eventDao.findEventM(-1, null, null, null, null, -1, event_publisher, -1); 
    	 
    	 //如果查询结果publishEventList为空
    	 //则返回一个空 List
	     return (publishEventList == null) ? (new ArrayList<Event>()) : publishEventList;
     }


     @Override 
     public List<Object> checkTakePartInUserInfo(int event_id, int event_publisher) {
	     
    	 this.eventDao = new EventDaoImpl();
	     this.event_summaryDao = new Event_summaryDaoImpl();
	     this.customerDao  = new CustomerDaoImpl();
	     this.adminDao  = new AdminDaoImpl();
	     
	     
	     //如果该管理员并不是发布者
	     //返回 一个空 List
	     if(this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1)==null)  return (new ArrayList<Object>() );
	     
	     //通过活动  id 查找该所有参与该活动的用户 id
		 List<Event_summary> etsy = this.event_summaryDao.findEvent_summaryM(event_id, -1);
    	 
		 
		 //遍历 List etsy
		 //从中获取用户 id
		 //并获取相应的普通用户或管理员信息
		 List<Object> userInfo  = new ArrayList<Object>();
		 for( int i=0; i<etsy.size(); i++){
			 
			 int event_customer = etsy.get(i).getEvent_id();
			 
			 if( event_customer >= 2000000000 )  
				   userInfo.addAll( this.customerDao.findCustomerM( event_customer, null, null, -1, null, null, null, -1, -1, null, -1)); 
			 else  userInfo.addAll( this.adminDao.findAdminM( event_customer, null, null)); 				       
		 }
		 
		 //返回信息List
    	 return userInfo;
     }		

}