package com.scuthnweb.service.interf;

import java.util.Date;
import java.util.List;

import com.scuthnweb.domain.Event;

public interface ActModule {
	
	/**
	 * Jun:�鿴���еĻ��Ϣ
	 * @validate no
	 * @interrupt no
	 * @return
	 */
	public List<Event> checkAllAct( boolean isAdmin);
	
	/**
	 * Jun:�鿴��ǰ�û���������л
	 * @validate no
	 * @interrupt yes
	 * @param event_customer
	 * @return
	 */
	public List<Event> checkTakePartIn( int event_customer);
	
	
	/**
	 * Jun:����Ա�鿴�Լ�������ȫ��� 
	 * @validate no
	 * @interrupt yes
	 * @param event_publisher
	 * @return
	 */
	public List<Event> checkPublish(int event_publisher);
	
	
	/**
	 * Jun:����Ա�鿴�μӻ���û���Ϣ
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_publisher
	 * @return
	 */
	public List<Object> checkTakePartInUserInfo( int event_id, int event_publisher);
	
	
	/**
	 * Jun:�˳��
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
	public boolean exitAct( int event_id, int event_customer);
	
	
	
	/**
	 * Jun:���߻
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @return
	 */
	public boolean offLineAct( int event_id, int event_publisher);
	
	
	/**
	 * Jun:���߻
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
	 * Jun:�μӻ
	 * @validate no
	 * @interrupt yes
	 * @param event_id
	 * @param event_customer
	 * @return
	 */
    public boolean takePartInAct(int event_id, int event_customer);
}
