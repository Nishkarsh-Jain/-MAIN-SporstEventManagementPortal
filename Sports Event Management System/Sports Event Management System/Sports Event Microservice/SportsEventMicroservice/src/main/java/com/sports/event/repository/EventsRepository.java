package com.sports.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sports.event.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

	 Events findByEventName(String eventName);
	
}
