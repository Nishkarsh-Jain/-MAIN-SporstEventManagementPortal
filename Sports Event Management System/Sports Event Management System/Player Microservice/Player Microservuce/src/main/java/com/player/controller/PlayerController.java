package com.player.controller;

import java.util.List;

import com.player.Feign.authClient;
import com.player.entity.JwtResponse;
import com.player.response.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.player.entity.Player;
import com.player.service.PlayerService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author (POD-4)
 * 
 *         Controller class for Player Microservice
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
@RequestMapping("/pm")
public class PlayerController {

	@Autowired
	private PlayerService ps;
	@Autowired
	private authClient auth;

	/**
	 * To add player
	 * 
	 * @param token
	 * @param Player object
	 * @return String based on addition of player
	 */

	@Operation(summary = "To add new Player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Player added Successfully", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and a new player has been created", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })

	@PostMapping("/addPlayer")
	public ResponseEntity<?> addPlayer(@RequestHeader(name = "authorization", required = true) String token,
			@RequestBody Player player) {
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.info("Inside addPlayer method of the Player Controller.");
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			String ev = ps.addPlayer(player);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * To delete Player
	 * 
	 * @param token
	 * @param playerId
	 * @return String based on deletion of player
	 */

	@Operation(summary = "To delete a Player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully deleted", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and event is deleted", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })

	@DeleteMapping("/deletePlayer/{playerId}")
	public ResponseEntity<?> deletePlayer(@RequestHeader(name = "authorization", required = true) String token,
			@PathVariable Long playerId) {
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.info("Inside deletePlayer method of the Player Controller.");
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			String ev = ps.deletePlayer(playerId);
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

	/**
	 * display list of all Players
	 * 
	 * @param token
	 * @return list of players
	 */

	@Operation(summary = "To display list of players.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/players")
	public ResponseEntity<?> listAllPlayers(@RequestHeader(name = "authorization", required = true) String token) {
		log.info("Inside listAllPlayer method of the Player Controller.");
		JwtResponse jwtResponse = auth.verifyToken(token);
		log.debug("jwt validity:", jwtResponse.isValid());
		if (jwtResponse.isValid()) {
			List<Player> ev = ps.listAllPlayers();
			return ResponseHandler.generateResponse("Successfully updated user data!", HttpStatus.OK, ev);
		} else {
			return ResponseHandler.generateResponse("Token expired", HttpStatus.MULTI_STATUS, null);
		}
	}

}
