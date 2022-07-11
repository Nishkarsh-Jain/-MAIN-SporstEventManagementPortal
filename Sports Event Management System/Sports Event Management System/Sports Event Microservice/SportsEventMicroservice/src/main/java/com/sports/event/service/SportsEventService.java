package com.sports.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sports.event.entity.Sports;
import com.sports.event.entity.Events;
import com.sports.event.repository.EventsRepository;
import com.sports.event.repository.SportsRepository;

@Service
public class SportsEventService {

	@Autowired
	private SportsRepository sr;

	@Autowired
	private EventsRepository er;

	@Autowired
	private Sports sports;

	@Autowired
	private Events events;

	public List<Sports> listAllSportsDetails() {
		List<Sports> sList = (List<Sports>) this.sr.findAll();
		return sList;
	}

	public Sports getSportsByName(String sportName) {
		sports = this.sr.findBySportsName(sportName);
		return sports;
	}

	public Events addEvent(Events event) {
		events = this.er.save(event);
		String result = events + " added successfully";
		return events;
	}

	public String deleteEvent(Long eventId) {
		String result = er.findById(eventId) + " deleted successfully";
		 er.deleteById(eventId);
		 return result;

	}

	public List<Events> events() {
		List<Events> eList = (List<Events>) this.er.findAll();
		return eList;
	}

	public Events eventsByName(String eventName) {
		events = er.findByEventName(eventName);
		return events;
	}

}
