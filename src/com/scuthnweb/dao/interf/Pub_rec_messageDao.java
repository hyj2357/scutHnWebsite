package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Message;



public interface Pub_rec_messageDao {
         /**
          * 
          * @param message_receiver
          * @param message_publisher
          * @param message_id
          */
	     public  Message     createPub_rec_Message( int message_receiver, int message_publisher, int message_id);
         
	     
	     /**
	      * Jun:����ʽ���½ӷ���Ϣ��
	      * @param message_receiver
	      * @param message_receiverM
	      * @param message_publisher
	      * @param message_id
	      */
         public  Message     updatePub_rec_Message( int message_receiver, int message_receiverM, int message_publisher, int message_id);
         
         
         /**
          * Jun:����ʽ���ҽӷ���Ϣ��
          * @param message_receiver
          * @param message_publisher
          * @param message_id
          * @return
          */
         public  List<Message>     findPub_rec_MessageM( int message_receiver, int message_publisher, int message_id);
         
         
         /**
          * 
          * @param message_receiver
          * @return
          */
         public  Message  findByReciever( int message_receiver);

}

