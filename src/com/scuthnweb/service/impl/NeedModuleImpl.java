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
		
		//����Dao�㷽��
		Pub_rec_need prn = this.pub_rec_needDao.createPub_rec_need( need_id, need_reciever );
		
		if( prn == null) return false;
		
		//������������Ϣ���͸����󷢲���
	    this.messageDao.createMessage(message_id,  "��ϲ������������" + need.getNeed_name() + "��" 
		                                         + "(����id:" + need_id + ")" 
	    		                                 + "�������û�����, " + "<br/>"
		                                         + "�鿴������������Բ鿴���������û��������Ϣ�����뾡����ϵ���û���" );
	    
		this.pub_rec_messageDao.createPub_rec_Message(need.getNeed_publisher(), need_reciever, message_id);
		
		return true;
	}


	@Override
	public boolean cancelAcNeed(int need_id, int need_receiver) {
	
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();

		//���� Dao �㷽��
		//ɾ���ɹ����� true
		//���򷵻� false
		return this.pub_rec_needDao.deletePub_rec_need(need_id, need_receiver);
	}


	@Override
	public List<Need> checkAllNeed( boolean isAdmin ) {
		
		this.needDao = new NeedDaoImpl();
		
		//�����ǰ�鿴��Ϊ����Ա
		//�������з���������
		//�����ǰ�鿴��Ϊ��ͨ�û����ο�
		//����δ���ý��������
		List<Need> needList = new ArrayList<Need>();
		if( isAdmin)  needList.addAll(this.needDao.findNeedM(-1, null, null, -1,-1));
		else          needList.addAll(this.needDao.findNeedM(-1, null, null, -1, 0));
		
		return needList;
	}


	@Override
	public List<Need> checkPostNeed(int need_publisher) {
		
		this.needDao = new NeedDaoImpl();
        
		//���� Dao �㷽�����������
		List<Need> needList = this.needDao.findNeedM(-1, null, null, need_publisher, -1);
		
		//�����ѯ��� needList Ϊnull
		//�򷵻�һ���� List
		return (needList==null) ? ( new ArrayList<Need>() ) : needList;
	}


	@Override
	public List<Need> checkAcNeed(int need_receiver) {
		
		this.pub_rec_needDao = new Pub_rec_needDaoImpl();
		this.needDao         = new NeedDaoImpl();
		
		//���� Dao �㷽��
		List<Pub_rec_need> pub_rec_needList = this.pub_rec_needDao.findPub_rec_needM(-1, need_receiver);		
		
		
		List<Need> needList = new ArrayList<Need>();
		
		//Ϊ�˱���������� NullPointerException �쳣
		//�ȶԷ��ص� pub_rec_needList �����ж�
		//���Ϊ null 
		//��  return needList( needList ��ʱû��Ԫ�� )
		if( pub_rec_needList != null ) return needList;
		
		//ͨ�����û����ܵĵ��������� id ����������Ϣ		
		for( int i=0; i < pub_rec_needList.size() ; i++) 
			needList.addAll( this.needDao.findNeedM( (pub_rec_needList.get(i)).getNeed_id(), null, null, -1, -1));
		
		return needList;
	}


	@Override
	public List<Object> checkAcNeedUserInfo(int need_id, int need_publisher) {
		
		this.pub_rec_needDao = new Pub_rec_needDaoImpl();
		this.customerDao     = new CustomerDaoImpl();
		this.adminDao        = new AdminDaoImpl();
				
		//���� Dao �㷽��
		List<Pub_rec_need> pub_rec_needList = this.pub_rec_needDao.findPub_rec_needM(need_id, need_publisher);
		
		
		List<Object>  AcNeedUserInfoList = new ArrayList<Object>();
		
		//Ϊ�˱���������� NullPointerException �쳣
		//�ȶԷ��ص� pub_recs_needList �����ж�
		//���Ϊ null 
		//��  return AcNeedUserInfoList( AcNeedUserInfoList ��ʱû��Ԫ�� )
		if( pub_rec_needList == null ) return AcNeedUserInfoList;
	
		
		//ͨ�����û����ܵĵ��������� id ����������Ϣ		
		for( int i=0; i < pub_rec_needList.size() ; i++) {
			//��ȡ���������û�id
			int need_receiver = (pub_rec_needList.get(i)).getNeed_receiver();
            
			//���������Ϊ��ͨ�û�
			//���� Customer ���в�ѯ
			//�����ѯ Admin ��
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
		
		//�����ǰ���ǹ���Ա�ڲ���
		//���Ҹ������Ǹ��û�������
		//���� false
		if( need_publisher >= 2000000000 ) 
			if( this.needDao.findNeedM(need_id, null, null, need_publisher, -1) == null) return false;
		
		//��ȡ�����������Ϣ
		List<Pub_rec_need> pub_rec_needList =  new ArrayList<Pub_rec_need>();
		pub_rec_needList.addAll( this.pub_rec_needDao.findPub_rec_needM(need_id, -1));
		
		//��ȡ������
		String needName  = this.needDao.findNeedM(need_id, null, null, -1, -1).get(0).getNeed_name();

		
		for( int i=0; i< pub_rec_needList.size(); i++){
			//����ܸ�������û����������ѱ���������Ϣ
			this.messageDao.createMessage(message_id, "�����ܵ�����"+needName+"��(" 
		                                             +"����id��" + need_id 
		                                             + ")�Ѿ�����.<br/>��л���Ը������ṩ��֧�֣�");			
			this.pub_rec_messageDao.createPub_rec_Message(pub_rec_needList.get(i).getNeed_receiver(), need_publisher, message_id);
			
			//�ڽ����������ɾ����Ϣ
			this.pub_rec_needDao.deletePub_rec_need(need_id, pub_rec_needList.get(i).getNeed_receiver());
		}
		
		//���������ɾ��������Ϣ
		return this.delNeed(need_id, need_publisher);
	}

	
	@Override
	public boolean postNeed(String need_name, String need_content, int need_publisher) {
		
		this.needDao = new NeedDaoImpl();
		
		//���� Dao �㷽��
		//�����ɹ����� true
		//���򷵻� false
		return (this.needDao.createNeed(need_name, need_content, need_publisher)==null)? false : true;
	}	
	
	
	@Override
	public boolean modifyNeed(int need_id, String need_name, String need_content) {
		
		 this.needDao = new NeedDaoImpl();
		
		 //���� Dao �㷽��
		 //ÿ���޸�����֮�󶼻�Ĭ�Ͻ�������Ϊδ���
		 return (this.needDao.updateNeed(need_id, -1, need_name, need_content, 0)==null) ? false : true;
		
		}

	
	
	@Override
	public boolean setNeedSucc(int need_id,int need_publisher) {
		
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		this.pub_rec_needDao    = new Pub_rec_needDaoImpl();
		this.needDao            = new NeedDaoImpl();
		
		
		//����Dao�㷽��
		if(this.needDao.updateNeed(need_id, -1, null, null, 1)==null) return false;
		
		
		//��ȡ�����������Ϣ
		List<Pub_rec_need> pub_rec_needList =  new ArrayList<Pub_rec_need>();
		pub_rec_needList.addAll( this.pub_rec_needDao.findPub_rec_needM(need_id, -1));
				
		//��ȡ������
		String needName  = this.needDao.findNeedM(need_id, null, null, -1, -1).get(0).getNeed_name();

				
		for( int i=0; i< pub_rec_needList.size(); i++){
		    //����ܸ�������û����������ѱ���������Ϣ
		    this.messageDao.createMessage(message_id,  "�����ܵ�����" + needName + "��(" 
				                                     + "����id��" + need_id 
				                                     + ")�Ѿ����.<br/>��л���Ը������ṩ��֧�֣�");			
		    this.pub_rec_messageDao.createPub_rec_Message(pub_rec_needList.get(i).getNeed_receiver(), need_publisher, message_id);
					
		    //�ڽ����������ɾ����Ϣ
		    this.pub_rec_needDao.deletePub_rec_need(need_id, pub_rec_needList.get(i).getNeed_receiver());
		}
		
		return true;
	}
	
}