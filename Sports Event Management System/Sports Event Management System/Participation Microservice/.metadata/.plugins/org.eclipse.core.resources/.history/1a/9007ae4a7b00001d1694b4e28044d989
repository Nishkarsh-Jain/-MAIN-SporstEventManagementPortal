package com.participation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.participation.entity.Participation;
import com.participation.repository.ParticipationRepository;

@Service
public class ParticipationService {

	@Autowired
	private ParticipationRepository pr;

	@Autowired
	private Participation participation;

	public String addParticipation(Participation part) {
		Participation participation = pr.save(part);
		return participation + " added successfully";
	}

	public List<Participation> listAllParticipation() {
		List<Participation> pList = (List<Participation>) pr.findAll();
		return pList;
	}
/*
	public String updateStatus(Participation part, Long partId) {
		Boolean status = false;
		if (partId == participation.getParticipationId()) {
			pr.save(part);
			status = true;
		}
		String result = "Declined";
		if (status) {
			result = "Approved";
		}
		return result;
	}
*/
	public List<Participation> listApprovedParticipations() {
		List<Participation> aList = pr.findByStatus("Approved");
		return aList;
	}

	public List<Participation> listDeclinedParticipations() {
		List<Participation> dList = pr.findByStatus("Declined");
		return dList;
	}
	

	public List<Participation> listPendingParticipations() {
		List<Participation> pList = pr.findByStatus("Pending");
		return pList;
	}

}
