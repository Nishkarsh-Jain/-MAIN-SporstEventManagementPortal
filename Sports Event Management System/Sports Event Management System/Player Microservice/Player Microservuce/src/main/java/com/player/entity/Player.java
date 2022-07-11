package com.player.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long playerId;
	private String playerName;
	private int age;
	private String contactNumber;
	private String email;
	private String gender;
	private String sportsname;

}
