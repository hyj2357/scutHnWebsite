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
	
	    //��ȡ�����ӵ������Ϣ
	     Share_link shl = this.share_linkDao.findShare_linkM(share_link_id, null, null, -1, -1).get(0);
	     
	     //���ɾ�������߼Ȳ��ǹ���ԱҲ�����ϴ������ӵ��û�
	     //���� false
	     //���ɾ��������Ϊ����ͨ�û�
	     //�� isAdmin ��Ϊ false
         if( share_link_publisher >= 2000000000)
    	    if( this.share_linkDao.findShare_linkM(share_link_id, null, null, share_link_publisher, -1) ==null) 
    		     return    false;
    	    else isAdmin = false;
	
         //����Dao�㷽��
         //ɾ������ʧ��
         //����false
         if( !this.share_linkDao.deleteShare_link(share_link_id, share_link_publisher))
    	         return false;
    
	     //��ɾ�����ӵ���Ϊ����Ա
		 if( isAdmin ){
		    //������Ϣ
		    this.messageDao.createMessage( message_id, "���ϴ������ӣ�id:" + share_link_id + " �ѱ�����Աɾ��.");
		    //����ʾ��Ϣ�������ӷ�����
	        this.pub_rec_messageDao.createPub_rec_Message( shl.getShare_link_publisher(), share_link_publisher, message_id);
		  }
		    
	   return true;
}


d
��Ŀ����1
	@Override
	public boolean op_Link( int share_link_id, int setState, int share_link_publisher) {
		
		this.share_linkDao      = new Share_linkDaoImpl();
		this.messageDao         =  new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		//���� Dao �㷽��
		Share_link  sl;
		if( ( sl=this.share_linkDao.updateShare_link(share_link_id, -1, null, null, setState) ) == null )
			return false;
				
		
	    if( setState == 0 ) this.messageDao.createMessage( message_id, "���ϴ��� id Ϊ��" + share_link_id + " ����" +
		                                                               "�Ѿ�������Ա��˲�ͨ��");
	    else                this.messageDao.createMessage( message_id, "���ϴ��� id Ϊ"  + share_link_id + " ����" +
		                                                               "��������Ա���δͨ������ѡ���ϴ��Ϸ�������"); 
        return true;
	}

	
	
	@Override
	public boolean updateLink(int share_link_id, int share_link_publisher, String share_link_name, String share_link_content) {
		
		this.share_linkDao      = new Share_linkDaoImpl();
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		boolean  isAdmin = true;
		
		//����޸������߼Ȳ��ǹ���ԱҲ�����ϴ������ӵ��û�
		//���� false
		//����޸�������Ϊ����ͨ�û�
		//�� isAdmin ��Ϊ false
	    if( share_link_publisher >= 2000000000)
	    	if( this.share_linkDao.findShare_linkM(share_link_id, null, null, share_link_publisher, -1)==null) 
	    		 return    false;
	    	else isAdmin = false;
		
	    //�޸�����ʧ��
	    //����false
	    if( this.share_linkDao.updateShare_link(share_link_id, -1, share_link_name, share_link_content, -1)==null)
	    	 return false;
	    
		//����޸ĵ��������ݲ�Ϊ��
		if( share_link_content != null) {

			    //���޸����ӵ���Ϊ����Ա
			    if( isAdmin ){
			        //������Ϣ
			        this.messageDao.createMessage( message_id, "���ϴ������ӣ�id:" + share_link_id + " �ѱ�����Ա�޸�.");
			        //����ʾ��Ϣ�������ӷ�����
		            this.pub_rec_messageDao.createPub_rec_Message( this.share_linkDao.findShare_linkM(share_link_id, null, null, -1, -1).get(0).getShare_link_publisher(), 
		            		                                       share_link_publisher, 
		            		                                       message_id );
			    }			    
			    //����ǰΪ�ϴ������ӵ��û��޸ĸ�����
			    else {
			    	   //������Ϣ
			    	   this.messageDao.createMessage( message_id, "�û� "+ share_link_publisher +"�޸���"+" ����(id:" + share_link_id + ") �����������.");
			    	   //����ʾ��Ϣ��������Ա
			    	   this.pub_rec_messageDao.createPub_rec_Message( message_receiver, share_link_publisher, message_id);
			          
			    	   //��ʱ��������Ϊ�����״̬
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
		
		//��������
		Share_link sl = this.share_linkDao.createShare_link(share_link_name, share_link_content, share_link_publisher);
		
		//����ʧ��
		//���� false
		if( sl == null ) return false;
		
		//�����Ա�����������������Ϣ
		this.messageDao.createMessage(message_id, "�����ϴ������ӣ�" + share_link_name + "<br/>" + share_link_content + "<br/>" +"����ˣ�");
		this.pub_rec_messageDao.createPub_rec_Message(message_receiver, share_link_publisher, message_id);
		
		return true; 
	}
	


	@Override
	public List<Share_link> checkAllResLink(boolean isAdmin) {
		
		this.share_linkDao = new Share_linkDaoImpl();
		
		//���� Dao �����ط���
		List<Share_link> share_linkList;
		if( isAdmin ) share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1, -1);
		else          share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1,  0);
		
		//��� share_linkList Ϊ null
		//�򷵻�һ��û��Ԫ�صĿ� List 
		return ( share_linkList == null) ? (new ArrayList<Share_link>()) : share_linkList;

	}



	@Override
	public List<Share_link> checkUploadLink(int share_link_publisher) {
		
		this.share_linkDao = new Share_linkDaoImpl();
		
		//����Dao�㷽����ѯ�û��ϴ�������
		List<Share_link> share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, share_link_publisher, -1);
		
		//�����ѯ���Ϊ��
		//����һ���� List
		return ( share_linkList == null ) ? ( new ArrayList<Share_link>() ) : share_linkList;
	}



	@Override
	public List<Share_link> checkVerifyLink( ) {
		
		this.share_linkDao = new  Share_linkDaoImpl();
		
		//���� Dao �㷽����ѯ���ڴ����״̬������
		List<Share_link> share_linkList = this.share_linkDao.findShare_linkM(-1, null, null, -1, 2);
		
		//�����ѯ��� share_linkList Ϊ�� 
		//����һ����list
		return  ( share_linkList == null) ? ( new ArrayList<Share_link>() ) : share_linkList;
	}
	
}
