package com.scuthnweb.dao.interf;

import java.util.Date;
import java.util.List;

import com.scuthnweb.domain.Event;

public interface EventDao {
	
	/**
	 * 
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @param event_publisher
	 * @return
	 */
	public  Event createEvent( String event_name,
			                   String event_intro,
			                   Date   event_time,
			                   Date   event_endtime,
			                   int    event_maxPeople,
			                   int    event_publisher );
	
	
	/**
	 * Jun:条件式更新活动信息表
	 * @param event_id
	 * @param event_idM
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @return
	 */
	public  Event updateEvent( int    event_id,
			                   int    event_idM,
			                   String event_name,
                               String event_intro,
                               Date   event_time,
                               Date   event_endtime,
                               int    event_maxPeople,
                               int    event_state);
	
	
	
	/**
	 * Jun:条件式查询活动信息
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @param event_publisher
	 * @param event_state
	 * @return
	 */
	public  List<Event> findEventM(
			                   int    event_id,
			                   String event_name,
                               String event_intro,
                               Date   event_time,
                               Date   event_endtime,
                               int    event_maxPeople,
                               int    event_publisher,
			                   int    event_state); 
	
	/**
	 * 
	 * @param event_id
	 * @return
	 */
	public  Event findByEventId(int   event_id);  

}
