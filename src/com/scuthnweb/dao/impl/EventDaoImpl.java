package com.scuthnweb.dao.impl;

import java.util.Date;
import java.util.List;

import com.scuthnweb.dao.interf.EventDao;
import com.scuthnweb.domain.Event;

public class EventDaoImpl implements EventDao{

	@Override
	public Event createEvent(String event_name, String event_intro,
			Date event_time, Date event_endtime, int event_maxPeople,
			int event_publisher) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Event findByEventId(int event_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateEvent(int event_id, int event_idM, String event_name,
			String event_intro, Date event_time, Date event_endtime,
			int event_maxPeople, int event_state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventM(int event_id, String event_name, String event_intro,
			Date event_time, Date event_endtime, int event_maxPeople,
			int event_publisher, int event_state) {
		// TODO Auto-generated method stub
		return null;
	}

}
