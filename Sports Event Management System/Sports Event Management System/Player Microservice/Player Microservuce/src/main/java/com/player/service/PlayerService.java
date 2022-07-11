package com.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.entity.Player;
import com.player.repository.PlayerRepository;

@Service
public class PlayerService {

	/*
	 * o POST:/addPlayer (Input: Player object | Output: Player +” added
	 * successfully”) o DELETE:/deletePlayer (Input: player id which is already
	 * exists | Output: Player Object +” removed successfully”) o
	 * GET:/players(Input: None| Output: ListAllPlayers)
	 */

	@Autowired
	private PlayerRepository pr;

	public String addPlayer(Player player) {
		pr.save(player);
		String result = player + " added successfully";
		return result;
	}

	public String deletePlayer(Long playerId) {
		String result = pr.findByPlayerId(playerId) + " removed successfully";
		pr.deleteById(playerId);
		return result;
	}

	public List<Player> listAllPlayers() {
		List<Player> pList = (List<Player>) pr.findAll();
		return pList;
	}
}
