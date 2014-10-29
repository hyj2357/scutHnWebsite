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
	      * Jun:条件式更新接发信息表
	      * @param message_receiver
	      * @param message_receiverM
	      * @param message_publisher
	      * @param message_id
	      */
         public  Message     updatePub_rec_Message( int message_receiver, int message_receiverM, int message_publisher, int message_id);
         
         
         /**
          * Jun:条件式查找接发信息表
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

