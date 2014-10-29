package com.scuthnweb.service.interf;

import java.util.Date;
import java.util.List;

import com.scuthnweb.domain.Event;

public interface ActModule {
	
	/**
	 * Jun:查看所有的活动信息
	 * @validate no
	 * @interrupt no
	 * @return
	 */
	public List<Event> checkAllAct( boolean isAdmin);
	
	/**
	 * Jun:查看当前用户参与的所有活动
	 * @validate no
	 * @interrupt yes
	 * @param event_customer
	 * @return
	 */
	public List<Event> checkTakePartIn( int event_customer);
	
	
	/**
	 * Jun:管理员查看自己发布的全部活动 
	 * @validate no
	 * @interrupt yes
	 * @param event_publisher
	 * @return
	 */
	public List<Event> checkPublish(int event_publisher);
	
	
	/**
	 * Jun:管理员查看参加活动的用户信息
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_publisher
	 * @return
	 */
	public List<Object> checkTakePartInUserInfo( int event_id, int event_publisher);
	
	
	/**
	 * Jun:退出活动
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
	public boolean exitAct( int event_id, int event_customer);
	
	
	
	/**
	 * Jun:下线活动
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @return
	 */
	public boolean offLineAct( int event_id, int event_publisher);
	
	
	/**
	 * Jun:上线活动
	 * @validate yes
	 * @interrupt yes 
	 * @param event_id
	 * @param event_name
	 * @param event_intro
	 * @param event_time
	 * @param event_endtime
	 * @param event_maxPeople
	 * @param event_publisher
	 * @param event_state
	 * @return
	 */
	public boolean onLineAct(int    event_id,
			                 String event_name,
			                 String event_intro,
			                 Date   event_time,
			                 Date   event_endtime,
			                 int    event_maxPeople,
			                 int    event_publisher,
			                 int    event_state);
    
	/**
	 * Jun:参加活动
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
    public boolean takePartInAct(int event_id, int event_customer);
}
