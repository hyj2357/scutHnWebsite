package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Message;

public interface MessageDao {
          public void createMessage(int message_id, String message_content);
          
          /**
           * Jun:条件式更新站内消息表
           * @param message_id
           * @param message_idM
           * @param message_content
           */
          public void updateMessage(int message_id, int message_idM, String message_content);
          
          
          /**
           * Jun：条件式查找站内信息
           * @param message_id
           * @return
           */
          public List<Message> findMessageM( int message_i, String message_content );
          
          
          public Message findByMessage_ID( int message_id );
}
