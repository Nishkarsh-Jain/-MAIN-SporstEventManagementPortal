package com.participation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long participationId;
	private Long playerId;
	private String playerName;
	private Long eventId;
	private String eventName;
	private Long sortsId;
	private String sportsName;
	private String status;

}
