package com.participation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.participation.entity.Participation;
import com.participation.service.ParticipationService;

@RestController
@RequestMapping("/pm")
public class ParticipationController {

	@Autowired
	private ParticipationService ps;

	@PostMapping("/addParticipation")
	public String addParticipation(@RequestBody Participation part) {
		return ps.addParticipation(part);
	}

	@GetMapping("/participations")
	public List<Participation> listAllParticipation() {
		return ps.listAllParticipation();
	}
/*
	@PutMapping("/updateStatus/{partId}")
	public String updateStatus(Participation participation, @PathVariable("partId") Long partId) {
		return ps.updateStatus(participation,partId);
	}
*/
	@GetMapping("/approvedParticipations")
	public List<Participation> listApprovedParticipations() {
		return ps.listApprovedParticipations();
	}

	@GetMapping("/declinedParticipations")
	public List<Participation> listDeclinedParticipations() {
		return ps.listDeclinedParticipations();
	}

	@GetMapping("/pendingParticipations")
	public List<Participation> listPendingParticipations() {
		return ps.listPendingParticipations();
	}

}

