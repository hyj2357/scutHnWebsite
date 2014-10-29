package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Event_summary;

public interface Event_summaryDao {
	
	/**
	 * Jun:
	 * @param Event_id
	 * @param Event_customer
	 * @return
	 */	
	public Event_summary createEvent_summary( int Event_id, int Event_customer);
	

	/**
	 * Jun:条件式更新活动参与表信息
	 * @param Event_id
	 * @param Event_idM
	 * @param Event_customer
	 * @return
	 */
	public Event_summary upDateEvent_summary( int Event_id, int Event_idM, int Event_customer);
	
	
	/**
	 * Jun：条件式查找活动参与表
	 * @param Event_id
	 * @param Event_customer
	 * @return
	 */
	public List<Event_summary> findEvent_summaryM( int Event_id, int Event_customer);
	
	
	/**
	 * Jun:
	 * @param Event_id
	 * @return
	 */
	public Event_summary findByEvent_id( int Event_id );
	
	
	/**
	 * Jun:
	 * @param Event_customer
	 * @return
	 */
	public Event_summary findByEvent_customer( int Event_customer );

	
	/**
	 * 
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
	public boolean deleteEvent_summary( int event_id, int event_customer);
}
