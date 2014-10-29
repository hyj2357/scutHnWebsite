package com.scuthnweb.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.impl.Share_linkDaoImpl;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.dao.interf.Share_linkDao;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;


public class ResLinkModuleImpl implements ResLinkModule{
    
	private MessageDao         messageDao;
    private Pub_rec_messageDao pub_rec_messageDao;
    private Share_linkDao      share_linkDao;
	
 
	@Override
	public boolean delLink(int share_link_id, int share_link_publisher) {
		
	     this.share_linkDao      = new Share_linkDaoImpl();
	     this.messageDao         = new MessageDaoImpl();
	     this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
	
	     boolean  isAdmin = true;
	
	    //获取该链接的相关信息
	     Share_link shl = this.share_linkDao.findShare_linkM(share_link_id, null, null, -1, -1).get(0);
	     
	     //如果删除链接者既不是管理员也不是上传该链接的用户
	     //返回 false
	     //如果删除链接者为该普通用户
	     //将 isAdmin 设为 false
         if( share_link_publisher >= 2000000000)
    	    if( this.share_linkDao.findShare_linkM(share_link_id, null, null, share_link_publisher, -1) ==null) 
    		     return    false;
    	    else isAdmin = false;
	
         //调用Dao层方法
         //删除链接失败
         //返回false
         if( !this.share_linkDao.deleteShare_link(share_link_id, share_link_publisher))
    	         return false;
    
	     //若删除链接的人为管理员
		 if( isAdmin ){
		    //创建消息
		    this.messageDao.createMessage( message_id, "你上传的链接：id:" + share_link_id + " 已被管理员删除.");
		    //将提示消息发给链接发布者
	        this.pub_rec_messageDao.createPub_rec_Message( shl.getShare_link_publisher(), share_link_publisher, message_id);
		  }
		    
	   return true;
}


d
项目问题1
	@Override
	public boolean op_Link( int share_link_id, int setState, int share_link_publisher) {
		
		this.share_linkDao      = new Share_linkDaoImpl();
		this.messageDao         =  new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		//调用 Dao 层方法
		Share_link  sl;
		if( ( sl=this.share_linkDao.updateShare_link(share_link_id, -1, null, null, setState) ) == null )
			return false;
				
		
	    if( setState == 0 ) this.messageDao.createMessage( message_id, "你上传的 id 为：" + share_link_id + " 链接" +
		                                                               "已经过管理员审核并通过");
	    else                this.messageDao.createMessage( message_id, "你上传的 id 为"  + share_link_id + " 链接" +
		                                                               "经过管理员审核未通过，请选择上传合法的链接"); 
        return true;
	}

	
	
	@Override
	public boolean updateLink(int share_link_id, int share_link_publisher, String share_link_name, String share_link_content) {
		
		this.share_linkDao      = new Share_linkDaoImpl();
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		boolean  isAdmin = true;
		
		//如果修改链接者既不是管理员也不是上传该链接的用户
		//返回 false
		//如果修改链接者为该普通用户
		//将 isAdmin 设为 false
	    if( share_link_publisher >= 2000000000)
	    	if( this.share_linkDao.findShare_linkM(share_link_id, null, null, share_link_publisher, -1)==null) 
	    		 return    false;
	    	else isAdmin = false;
		
	    //修改链接失败
	    //返回false
	    if( this.share_linkDao.updateShare_link(share_link_id, -1, share_link_name, share_link_content, -1)==null)
	    	 return false;
	    
		//如果修改的链接内容不为空
		if( share_link_content != null) {

			    //若修改链接的人为管理员
			    if( isAdmin ){
			        //创建消息
			        this.messageDao.createMessage( message_id, "你上传的链接：id:" + share_link_id + " 已被管理员修改.");
			        //将提示消息发给链接发布者
		            this.pub_rec_messageDao.createPub_rec_Message( this.share_linkDao.findShare_linkM(share_link_id, null, null, -1, -1).get(0).getShare_link_publisher(), 
		            		                                       share_link_publisher, 
		            		                                       message_id );
			    }			    
			    //若当前为上传该链接的用户修改该链接
			    else {
			    	   //创建消息
			    	   this.messageDao.createMessage( message_id, "用户 "+ share_link_publisher +"修改了"+" 链接(id:" + share_link_id + ") ，请审核链接.");
			    	   //将提示消息发给管理员
			    	   this.pub_rec_messageDao.createPub_rec_Message( message_receiver, share_link_publisher, message_id);
			          
			    	   //暂时将链接设为待审核状态
			    	   this.share_linkDao.updateShare_link(share_link_id, -1, null, null, 2);
			    }
	    }
		
		return true;
	}

	
	
	@Override
	public boolean uploadLink(int share_link_publisher, String share_link_name, String share_link_content) {
		
		this.share_linkDao = new Share_linkDaoImpl();
		this.messageDao = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		//创建链接
		Share_link sl = this.share_linkDao.createShare_link(share_link_name, share_link_content, share_link_publisher);
		
		//创建失败
		//返回 false
		if( sl == null ) return false;
		
		//向管理员发送请求审核链接消息
		this.messageDao.createMessage(message_id, "有新上传的链接：" + share_link_name + "<br/>" + share_link_content + "<br/>" +"请审核！");
		this.pub_rec_messageDao.createPub_rec_Message(message_receiver, share_link_publisher, message_id);
		
		return true; 
	}
	


	@Override
	public List<Share_link> checkAllResLink(boolean isAdmin) {
		
		this.share_linkDao = new Share_linkDaoImpl();
		
		//调用 Dao 层的相关方法
		List<Share_link> share_linkList;
		if( isAdmin ) share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1, -1);
		else          share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1,  0);
		
		//如果 share_linkList 为 null
		//则返回一个没有元素的空 List 
		return ( share_linkList == null) ? (new ArrayList<Share_link>()) : share_linkList;

	}



	@Override
	public List<Share_link> checkUploadLink(int share_link_publisher) {
		
		this.share_linkDao = new Share_linkDaoImpl();
		
		//调用Dao层方法查询用户上传的链接
		List<Share_link> share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, share_link_publisher, -1);
		
		//如果查询结果为空
		//返回一个空 List
		return ( share_linkList == null ) ? ( new ArrayList<Share_link>() ) : share_linkList;
	}



	@Override
	public List<Share_link> checkVerifyLink( ) {
		
		this.share_linkDao = new  Share_linkDaoImpl();
		
		//调用 Dao 层方法查询处在待审核状态的链接
		List<Share_link> share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1, 2);
		
		//如果查询结果 share_linkList 为空 
		//返回一个空list
		return  ( share_linkList == null) ? ( new ArrayList<Share_link>() ) : share_linkList;
	}
	
}
