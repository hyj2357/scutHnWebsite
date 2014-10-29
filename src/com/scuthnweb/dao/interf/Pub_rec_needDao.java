package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Pub_rec_need;

public interface Pub_rec_needDao {
	/**
	 * 
	 * @param need_id
	 * @param need_receiver
	 * @return
	 */
	public  Pub_rec_need  createPub_rec_need( int need_id, int need_reciever);
	
	
	/**
	 * Jun:条件式更新接受需求表
	 * @param need_id
	 * @param need_idM
	 * @param need_receiver
	 * @return
	 */
	public  Pub_rec_need  updatePub_rec_need( int need_id, int need_idM, int need_receiver);
	
	
	/**
	 * Jun:条件式查找接受需求表
	 * @param need_id
	 * @param need_receiver
	 * @return
	 */
	public  List<Pub_rec_need>  findPub_rec_needM( int need_id, int need_receiver);
	
	
	/**
	 * 
	 * @param need_id
	 * @return
	 */
	public  Pub_rec_need  findByNeed_id( int need_id);
	
	
	/**
	 * 
	 * @param need_receiver
	 * @return
	 */
	public  Pub_rec_need  findByNeed_reciever( int need_receiver );
	
	/**
	 * 
	 * @param need_id
	 * @param need_receiver
	 * @return
	 */
	public  boolean deletePub_rec_need(int need_id, int need_receiver);

}
