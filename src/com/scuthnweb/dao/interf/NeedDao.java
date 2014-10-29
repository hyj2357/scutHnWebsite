package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Need;

public interface NeedDao {
  /**
   * 
   * @param need_name
   * @param need_content
   * @param need_publisher
   * @return
   */
   public Need createNeed(    String need_name,
	                          String need_content,
		                      int    need_publisher );
   
  
   /**
    * Jun:条件式更新需求表信息
    * @param need_id
    * @param need_idM
    * @param need_name
    * @param need_content
    * @param need_state
    * @return
    */
   public Need updateNeed(    int    need_id,
		                      int    need_idM,
		                      String need_name,
                              String need_content,
                              int    need_state);
   
   
   /**
    * Jun:条件式查找需求表信息
    * @param need_id
    * @param need_name
    * @param need_content
    * @param need_state
    * @return
    */
   public List<Need> findNeedM(  int    need_id,
                           String need_name,
                           String need_content,
                           int    need_publisher,
                           int    need_state);
   
   
   /**
    * 
    * @param need_id
    * @return
    */
   public List<Need> findByNeed_ID( int  need_id);
   
   
   /**
    * 
    * @param need_publisher
    * @return
    */
   public List<Need> findByNeed_publisher( int need_publisher);
   
   
   /**
    * 
    * @param need_id
    * @param need_state
    * @return
    */
   public boolean  deleteNeed( int need_id, int need_state);
}
