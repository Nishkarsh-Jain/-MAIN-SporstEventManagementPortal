package com.sports.event.controller;

import java.util.List;

import com.sports.event.Feign.authClient;
import com.sports.event.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sports.event.entity.Events;
import com.sports.event.entity.Sports;
import com.sports.event.service.SportsEventService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import com.sports.event.response.ResponseHandler;
import org.springframework.http.HttpStatus;

/**
 * Controller class for SportsEventMicroservice
 * 
 * @author POD-4
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/sem")
public class SportsEventController {

	@Autowired
	private SportsEventService ss;

	@Autowired
	private authClient auth;

	/**
	 * list all the sports
	 * 
	 * @param token
	 * @return ResponseEntity<List<Sports>>
	 */

	@Operation(summary = "To display all the Sports.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/sports")
	public ResponseEntity<?> listAllSportsDetails(
			@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Sports> ev = ss.listAllSportsDetails();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

	/**
	 * to search sport by its name
	 * 
	 * @param token
	 * @param sport name
	 * @return ResponseEntity<Sports>
	 */

	@Operation(summary = "To get specific Sport by its name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/sports/{sportName}")
	public ResponseEntity<?> getSportsByName(@RequestHeader(name = "authorization", required = true) String token,
			@PathVariable("sportName") String sportName) {
		log.info("Inside getSportsByName method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		log.info("Inside events method of the Sports Controller.");
		if (jwtResponse.isValid()) {
			Sports ev = ss.getSportsByName(sportName);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * to add event using events object
	 * 
	 * @param token
	 * @param events object
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To add new Event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and a new event has been created", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })

	@PostMapping("/addEvent")
	public ResponseEntity<?> addEvent(@RequestHeader(name = "authorization", required = true) String token,
			@RequestBody Events event) {
		log.info("Inside addEvent method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		log.info("Inside events method of the Sports Controller.");
		if (jwtResponse.isValid()) {
			Events ev = ss.addEvent(event);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * to delete event using event Id
	 * 
	 * @param token
	 * @param event id
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To delete an Event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully deleted", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and event is deleted", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })

	@DeleteMapping("/deleteEvent/{eventId}")
	public ResponseEntity<?> deleteEvent(@RequestHeader(name = "authorization", required = true) String token,
			@PathVariable("eventId") long eventId) {
		log.info("Inside delete method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			String ev = ss.deleteEvent(eventId);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}

	}

	/**
	 * to list all the events
	 * 
	 * @param token
	 * @return ResponseEntity<List<Events>>
	 */

	@Operation(summary = "To display all the Events.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/events")
	public ResponseEntity<?> events(@RequestHeader(name = "authorization", required = true) String token) {
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		log.info("Inside events method of the Sports Controller.");
		if (jwtResponse.isValid()) {
			List<Events> event = ss.events();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, event);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * to search event by its name
	 * 
	 * @param token
	 * @param event name
	 * @return ResponseEntity<Events>
	 */

	@Operation(summary = "To get specific Event by its name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/events/{eventName}")
	public ResponseEntity<?> eventsByName(@RequestHeader(name = "authorization", required = true) String token,
			@PathVariable("eventName") String eventName) {
		log.info("Inside eventNyName method of the Sports Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		// return ss.eventsByName(eventName);
		if (jwtResponse.isValid()) {
			Events event = ss.eventsByName(eventName);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, event);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

}
