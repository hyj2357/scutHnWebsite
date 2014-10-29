package com.scuthnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.scuthnweb.dao.impl.CustomerDaoImpl;
import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.AdminUser;

public class AdminUserImpl implements AdminUser{

	private CustomerDao        customerDao;
	private Pub_rec_messageDao pub_rec_messageDao;
	private MessageDao         messageDao;
	
	

	@Override
	public List<Customer> checkRegInfo() {
		
		this.customerDao = new CustomerDaoImpl();
		
		//���� Dao �㷽��
		List<Customer> regCustomerList = this.customerDao.findCustomerM(-1, null, null, -1, null, null, null, -1, -1, null, 1);
		
		//�����ѯ���Ϊ��
		//�򷵻� һ���� List
		return  (regCustomerList == null) ? ( new ArrayList<Customer>() ) : regCustomerList;
	}

	
	@Override
	public List<Customer> checkUserInfo(int    customer_id,
                                        String customer_name, 
			                            int    customer_sex,
			                            String customer_grade, 
			                            String customer_major, 
			                            int    customer_phone,
			                            int    customer_qq, 
			                            String customer_email, 
			                            String customer_room) {
		
		this.customerDao = new CustomerDaoImpl();
		
		//����Dao�㷽��
		List<Customer> userInfoList = this.customerDao.findCustomerM(customer_id, customer_name, null, customer_sex, customer_email, customer_grade, customer_major, customer_phone, customer_qq, customer_room, -1);
		
		//�����ѯ���Ϊ��
		//�򷵻� һ���� List
		return ( userInfoList == null) ? ( new ArrayList<Customer>()) : userInfoList;
	}

	
	@Override
	public boolean logoutUserID(int customer_id) {
		
		this.customerDao = new CustomerDaoImpl();
		
		//����Ȩ�ޣ���������ע��������
		//�����û�����Ȩ��
		if( this.customerDao.updateCustomer(customer_id, -1, null, null, -1, null, null, null, -1, -1, null,1)==null)
			  return false;		
		else  return true;
	}

	
//	@Override
	public boolean modifyUserInfo(int    admin_id, 
			                      int    customer_id,
			                      String customer_name, 
			                      String customer_password,
			                      int    customer_sex,
			                      String customer_grade, 
			                      String customer_major, 
			                      int    customer_phone,
			                      int    customer_qq, 
			                      String customer_email, 
			                      String customer_room) {
		
		this.customerDao        = new CustomerDaoImpl();
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		//�޸�ʧ��
		//���� false
		//�޸ĳɹ�
		//����Ϣ���������޸���Ϣ����ͨ�û�
		//������ true
		if( this.customerDao.updateCustomer(customer_id, -1, customer_name, customer_password, customer_sex, customer_email, customer_grade, customer_major, customer_phone, customer_qq, customer_room, -1)==null)
		      return false;
		else  {
			   this.messageDao.createMessage(message_id, "����Ա "+"(id:" + admin_id + ")"+"�޸������ĸ�����Ϣ��");
			   this.pub_rec_messageDao.createPub_rec_Message(customer_id, admin_id, message_id);
			   return true;
		}
	}
	
}