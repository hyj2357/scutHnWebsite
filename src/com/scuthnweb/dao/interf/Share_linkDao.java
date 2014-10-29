package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Share_link;

public interface Share_linkDao {
	/**
	 * 
	 * @param share_link_name
	 * @param share_link_content
	 * @param share_link_publisher
	 * @return
	 */
     public  Share_link createShare_link(   String  share_link_name, 
    		                                String  share_link_content, 
    		                                int     share_link_publisher);
     
     
    /**
     * Jun:条件式更新资源连接表
     * @param share_link_id
     * @param share_link_idM
     * @param share_link_name
     * @param share_link_content
     * @param share_link_state
     * @return
     */
     public  Share_link updateShare_link(   int     share_link_id,
    		                                int     share_link_idM,
    		                                String  share_link_name, 
                                            String  share_link_content,
                                            int     share_link_state );
     
     
     
     /**
      * Jun:条件式查找资源连接表
      * @param share_link_id
      * @param share_link_name
      * @param share_link_content
      * @param share_link_publisher 
      * @param share_link_state
      * @return
      */
     public  List<Share_link> findShare_linkM( int     share_link_id,
                                               String  share_link_name, 
                                               String  share_link_content,
                                               int     share_link_publisher,
                                               int     share_link_state );
     
     /**
      * 
      * @param share_link_id
      * @return
      */
     public  List<Share_link> findByShare_link_id(int  share_link_id);
     
     
     /**
      * 
      * @param share_link_id
      * @param share_link_publisher
      * @return
      */
     public  boolean  deleteShare_link( int share_link_id, int share_link_publisher);
}
