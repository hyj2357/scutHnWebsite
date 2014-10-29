package com.scuthnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.scuthnweb.dao.impl.AdminDaoImpl;
import com.scuthnweb.dao.impl.CustomerDaoImpl;
import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.NeedDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_needDaoImpl;
import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.NeedDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.dao.interf.Pub_rec_needDao;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Need;
import com.scuthnweb.domain.Pub_rec_need;
import com.scuthnweb.service.interf.NeedModule;

public class NeedModuleImpl implements NeedModule{

	private Pub_rec_needDao     pub_rec_needDao;
	private Pub_rec_messageDao  pub_rec_messageDao;
	private MessageDao          messageDao;
	private NeedDao             needDao;
	private CustomerDao         customerDao;
	private AdminDao            adminDao;
	
	@Override
	public boolean acceptNeed(int need_id, int need_reciever) {
		
		this.needDao            = new NeedDaoImpl();
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		Need need = this.needDao.findNeedM(need_id, null, null, -1, -1).get(0);
		
		//调用Dao层方法
		Pub_rec_need prn = this.pub_rec_needDao.createPub_rec_need( need_id, need_reciever );
		
		if( prn == null) return false;
		
		//将接受需求消息发送给需求发布者
	    this.messageDao.createMessage(message_id,  "恭喜您！您的需求“" + need.getNeed_name() + "”" 
		                                         + "(需求id:" + need_id + ")" 
	    		                                 + "被其他用户接受, " + "<br/>"
		                                         + "查看您的需求界面以查看接受需求用户的相关信息，并请尽快联系该用户！" );
	    
		this.pub_rec_messageDao.createPub_rec_Message(need.getNeed_publisher(), need_reciever, message_id);
		
		return true;
	}


	@Override
	public boolean cancelAcNeed(int need_id, int need_receiver) {
	
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();

		//调用 Dao 层方法
		//删除成功返回 true
		//否则返回 false
		return this.pub_rec_needDao.deletePub_rec_need(need_id, need_receiver);
	}


	@Override
	public List<Need> checkAllNeed( boolean isAdmin ) {
		
		this.needDao = new NeedDaoImpl();
		
		//如果当前查看者为管理员
		//返回所有发布的需求
		//如果当前查看者为普通用户或游客
		//返回未设置解决的需求
		List<Need> needList = new ArrayList<Need>();
		if( isAdmin)  needList.addAll(this.needDao.findNeedM(-1, null, null, -1,-1));
		else          needList.addAll(this.needDao.findNeedM(-1, null, null, -1, 0));
		
		return needList;
	}


	@Override
	public List<Need> checkPostNeed(int need_publisher) {
		
		this.needDao = new NeedDaoImpl();
        
		//调用 Dao 层方法查找需求表
		List<Need> needList = this.needDao.findNeedM(-1, null, null, need_publisher, -1);
		
		//如果查询结果 needList 为null
		//则返回一个空 List
		return (needList==null) ? ( new ArrayList<Need>() ) : needList;
	}


	@Override
	public List<Need> checkAcNeed(int need_receiver) {
		
		this.pub_rec_needDao = new Pub_rec_needDaoImpl();
		this.needDao         = new NeedDaoImpl();
		
		//调用 Dao 层方法
		List<Pub_rec_need> pub_rec_needList = this.pub_rec_needDao.findPub_rec_needM(-1, need_receiver);		
		
		
		List<Need> needList = new ArrayList<Need>();
		
		//为了避免下面出现 NullPointerException 异常
		//先对返回的 pub_rec_needList 进行判断
		//如果为 null 
		//则  return needList( needList 此时没有元素 )
		if( pub_rec_needList != null ) return needList;
		
		//通过该用户接受的的所有需求 id 查找需求信息		
		for( int i=0; i < pub_rec_needList.size() ; i++) 
			needList.addAll( this.needDao.findNeedM( (pub_rec_needList.get(i)).getNeed_id(), null, null, -1, -1));
		
		return needList;
	}


	@Override
	public List<Object> checkAcNeedUserInfo(int need_id, int need_publisher) {
		
		this.pub_rec_needDao = new Pub_rec_needDaoImpl();
		this.customerDao     = new CustomerDaoImpl();
		this.adminDao        = new AdminDaoImpl();
				
		//调用 Dao 层方法
		List<Pub_rec_need> pub_rec_needList = this.pub_rec_needDao.findPub_rec_needM(need_id, need_publisher);
		
		
		List<Object>  AcNeedUserInfoList = new ArrayList<Object>();
		
		//为了避免下面出现 NullPointerException 异常
		//先对返回的 pub_recs_needList 进行判断
		//如果为 null 
		//则  return AcNeedUserInfoList( AcNeedUserInfoList 此时没有元素 )
		if( pub_rec_needList == null ) return AcNeedUserInfoList;
	
		
		//通过该用户接受的的所有需求 id 查找需求信息		
		for( int i=0; i < pub_rec_needList.size() ; i++) {
			//获取接受需求用户id
			int need_receiver = (pub_rec_needList.get(i)).getNeed_receiver();
            
			//如果接受者为普通用户
			//则在 Customer 表中查询
			//否则查询 Admin 表
			if( need_receiver >= 2000000000 ) 
				  AcNeedUserInfoList.addAll( this.customerDao.findCustomerM(need_receiver, null, null, -1, null, null, null, -1, -1, null, -1));
			else  AcNeedUserInfoList.addAll(this.adminDao.findAdminM(need_receiver, null, null) );	
		}
			
		return AcNeedUserInfoList;
	}	
	
	
	
	@Override
	public boolean delNeed(int need_id , int need_publisher) {
		
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();
		this.needDao            = new NeedDaoImpl();
		
		//如果当前不是管理员在操作
		//而且该需求不是该用户所发布
		//返回 false
		if( need_publisher >= 2000000000 ) 
			if( this.needDao.findNeedM(need_id, null, null, need_publisher, -1) == null) return false;
		
		//获取接受需求表信息
		List<Pub_rec_need> pub_rec_needList =  new ArrayList<Pub_rec_need>();
		pub_rec_needList.addAll( this.pub_rec_needDao.findPub_rec_needM(need_id, -1));
		
		//获取需求名
		String needName  = this.needDao.findNeedM(need_id, null, null, -1, -1).get(0).getNeed_name();

		
		for( int i=0; i< pub_rec_needList.size(); i++){
			//向接受该需求的用户发送需求已被撤销的消息
			this.messageDao.createMessage(message_id, "您接受的需求“"+needName+"”(" 
		                                             +"需求id：" + need_id 
		                                             + ")已经撤销.<br/>感谢您对该需求提供的支持！");			
			this.pub_rec_messageDao.createPub_rec_Message(pub_rec_needList.get(i).getNeed_receiver(), need_publisher, message_id);
			
			//在接受需求表中删除信息
			this.pub_rec_needDao.deletePub_rec_need(need_id, pub_rec_needList.get(i).getNeed_receiver());
		}
		
		//在需求表中删除需求信息
		return this.delNeed(need_id, need_publisher);
	}

	
	@Override
	public boolean postNeed(String need_name, String need_content, int need_publisher) {
		
		this.needDao = new NeedDaoImpl();
		
		//调用 Dao 层方法
		//创建成功返回 true
		//否则返回 false
		return (this.needDao.createNeed(need_name, need_content, need_publisher)==null)? false : true;
	}	
	
	
	@Override
	public boolean modifyNeed(int need_id, String need_name, String need_content) {
		
		 this.needDao = new NeedDaoImpl();
		
		 //调用 Dao 层方法
		 //每次修改需求之后都会默认将需求设为未解决
		 return (this.needDao.updateNeed(need_id, -1, need_name, need_content, 0)==null) ? false : true;
		
		}

	
	
	@Override
	public boolean setNeedSucc(int need_id,int need_publisher) {
		
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();
		this.needDao            = new NeedDaoImpl();
		
		
		//调用Dao层方法
		if(this.needDao.updateNeed(need_id, -1, null, null, 1)==null) return false;
		
		
		//获取接受需求表信息
		List<Pub_rec_need> pub_rec_needList =  new ArrayList<Pub_rec_need>();
		pub_rec_needList.addAll( this.pub_rec_needDao.findPub_rec_needM(need_id, -1));
				
		//获取需求名
		String needName  = this.needDao.findNeedM(need_id, null, null, -1, -1).get(0).getNeed_name();

				
		for( int i=0; i< pub_rec_needList.size(); i++){
		    //向接受该需求的用户发送需求已被撤销的消息
		    this.messageDao.createMessage(message_id,  "您接受的需求“" + needName + "”(" 
				                                     + "需求id：" + need_id 
				                                     + ")已经解决.<br/>感谢您对该需求提供的支持！");			
		    this.pub_rec_messageDao.createPub_rec_Message(pub_rec_needList.get(i).getNeed_receiver(), need_publisher, message_id);
					
		    //在接受需求表中删除信息
		    this.pub_rec_needDao.deletePub_rec_need(need_id, pub_rec_needList.get(i).getNeed_receiver());
		}
		
		return true;
	}
	
}