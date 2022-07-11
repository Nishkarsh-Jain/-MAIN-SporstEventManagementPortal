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
	
	public boolean updateStatus(Participation partObj, Long partId) {
		Boolean status = false;
		if (pr.findByParticipationId(partId) != null) {
			pr.deleteById(partId);
			participation.setParticipationId(partId);
			pr.save(partObj);
			status = true;
		}
		return status;
	}
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
