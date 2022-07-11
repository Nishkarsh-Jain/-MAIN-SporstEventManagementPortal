package com.sports.event.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventId;
	private String eventDate;
	private String eventName;
	private int noofSlots;
	private String sportsName;

}
