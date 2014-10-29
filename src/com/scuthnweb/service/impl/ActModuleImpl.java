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
	//�˳��
	public boolean exitAct(int event_id, int event_customer) {
		
		this.event_summaryDao = new Event_summaryDaoImpl();
		
		//���� Dao ����
		//ɾ���ɹ����� true
		//���򷵻� false
		return  this.event_summaryDao.deleteEvent_summary(event_id, event_customer);		
	}
	

	@Override
	//���߻
	public boolean offLineAct(int event_id, int event_publisher) {
		
	    this.eventDao           = new EventDaoImpl();
	    this.messageDao         = new MessageDaoImpl();
	    this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
	    this.event_summaryDao   = new Event_summaryDaoImpl();
	    
	    //����û���Ǹù���Ա������
	    //�򷵻� false
	    if( this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1)==null ) return false;
	    
	    //���»����״̬ʧ��
	    //����  false
	    if( this.eventDao.updateEvent(event_id, -1, null, null, null, null, -1, 1) == null)  return false;
	    else {
	    	 //��ȡ�û����Ϣ
	    	 Event eventOffline = (Event)(this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1).get(0));
	    	 //��ȡ���в���û���û���
	    	 List<Event_summary> event_summaryList = this.event_summaryDao.findEvent_summaryM(event_id, -1);
	    
	         for( int i=0; i < event_summaryList.size(); i++){
	        	 
	        	 //�����û���û����ͻ���ߵ���Ϣ
	        	 this.messageDao.createMessage( message_id, "������Ļ��" + eventOffline.getEvent_name() 
	        			                                                 + "( �id:"+ eventOffline.getEvent_id() 
	        			                                                 + ")�Ѿ����ߣ���л���Ըû�Ĵ���֧�֣�ϣ�����ܸ�����뱾վ���");
	             
	        	 this.pub_rec_messageDao.createPub_rec_Message( event_summaryList.get(i).getEvent_customer(), event_publisher, message_id);
	             
	        	 //����ɾ�� Event_summary ���в�������Ϣ
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
	    
	    //�����ǰΪ����Ա
	    //�򷵻����л
	    //�������ͨ�û������ο�
	    //�򷵻ص�ǰվ�����ߵĻ
	    if( isAdmin )  et.addAll( this.eventDao.findEventM(-1, null, null, null, null, -1, -1, -1) );	    
	    else           et.addAll( this.eventDao.findEventM(-1, null, null, null, null, -1, -1,  0) ); 

	    return et;
    }


    @Override
    public List<Event> checkTakePartIn(int event_customer) {
	
	    this.event_summaryDao = new Event_summaryDaoImpl();
	    this.eventDao         = new EventDaoImpl();
	
        //ͨ���û� id ���Ҹ��û���������л id
	    List<Event_summary> etsy = this.event_summaryDao.findEvent_summaryM(-1, event_customer);
	
	    //ͨ�����û���������л id ���һ
	    List<Event> et = new  ArrayList<Event>();
	    for( int i=0; i<etsy.size(); i++)   et.addAll( this.eventDao.findEventM( etsy.get(i).getEvent_id(), null, null, null, null, -1, -1, -1));
	
	    return et;
     } 


     @Override
     public List<Event> checkPublish(int event_publisher) {
	    
    	 this.eventDao = new EventDaoImpl();
    	 
    	 //����Աͨ�� id �鿴�Լ������Ļ
    	 List<Event> publishEventList = this.eventDao.findEventM(-1, null, null, null, null, -1, event_publisher, -1); 
    	 
    	 //�����ѯ���publishEventListΪ��
    	 //�򷵻�һ���� List
	     return (publishEventList == null) ? (new ArrayList<Event>()) : publishEventList;
     }


     @Override 
     public List<Object> checkTakePartInUserInfo(int event_id, int event_publisher) {
	     
    	 this.eventDao = new EventDaoImpl();
	     this.event_summaryDao = new Event_summaryDaoImpl();
	     this.customerDao  = new CustomerDaoImpl();
	     this.adminDao  = new AdminDaoImpl();
	     
	     
	     //����ù���Ա�����Ƿ�����
	     //���� һ���� List
	     if(this.eventDao.findEventM(event_id, null, null, null, null, -1, event_publisher, -1)==null)  return (new ArrayList<Object>() );
	     
	     //ͨ���  id ���Ҹ����в���û���û� id
		 List<Event_summary> etsy = this.event_summaryDao.findEvent_summaryM(event_id, -1);
    	 
		 
		 //���� List etsy
		 //���л�ȡ�û� id
		 //����ȡ��Ӧ����ͨ�û������Ա��Ϣ
		 List<Object> userInfo  = new ArrayList<Object>();
		 for( int i=0; i<etsy.size(); i++){
			 
			 int event_customer = etsy.get(i).getEvent_id();
			 
			 if( event_customer >= 2000000000 )  
				   userInfo.addAll( this.customerDao.findCustomerM( event_customer, null, null, -1, null, null, null, -1, -1, null, -1)); 
			 else  userInfo.addAll( this.adminDao.findAdminM( event_customer, null, null)); 				       
		 }
		 
		 //������ϢList
    	 return userInfo;
     }		

}