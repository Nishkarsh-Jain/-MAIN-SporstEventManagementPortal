package com.participation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.participation.Feign.authClient;
import com.participation.entity.JwtResponse;
import com.participation.entity.Participation;
import com.participation.response.ResponseHandler;
import com.participation.service.ParticipationService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/*
 * Controller for Participation
 * 
 * @author (POD-4)
 * */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/pm")
public class ParticipationController {

	@Autowired
	private ParticipationService ps;

	@Autowired
	private authClient auth;

	/*
	 * to add new Participation request
	 * 
	 * @param Participation Object
	 * 
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To add new Participation request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully apply for paticipation", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and apply for participation", content = {
					@Content(mediaType = "application/json") }) })

	@PostMapping("/addParticipation")
	public ResponseEntity<?> addParticipation(@RequestHeader(name = "authorization", required = true) String token,
			@RequestBody Participation participation) {
		log.info("Inside addEvent method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		log.info("Inside events method of the Sports Controller.");
		if (jwtResponse.isValid()) {
			String ev = ps.addParticipation(participation);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/*
	 * to display all Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Participations request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/participations")
	public ResponseEntity<?> listAllParticipation(
			@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Participation> ev = ps.listAllParticipation();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

	/*
	 * to update the Participation request.
	 * 
	 * @return ResponseEntity<<String>>
	 */

	@Operation(summary = "To update the Participations request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }) })

	@PutMapping("/updateStatus/{partId}")
	public ResponseEntity<?> updateStatus(@RequestHeader(name = "authorization", required = true) String token,
			Participation participation, @PathVariable("partId") Long partId) {
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			if (ps.updateStatus(participation, partId)) {
				return new ResponseEntity<>(
						"Participation with participation id: " + partId + " is successfullly Updated!!!",
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Participation id is Invalid!!!", HttpStatus.BAD_REQUEST);
			}
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/*
	 * to display all Approved Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Approved Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/approvedParticipations")
	public ResponseEntity<?> listApprovedParticipations(
			@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Participation> ev = ps.listApprovedParticipations();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

	/*
	 * to display all Declined Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Declined Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/declinedParticipations")
	public ResponseEntity<?> listAllSportsDetails(
			@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Participation> ev = ps.listDeclinedParticipations();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

	/*
	 * to display all Pending Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Pending Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/pendingParticipations")
	public ResponseEntity<?> istPendingParticipations(
			@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Participation> ev = ps.listPendingParticipations();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

}
