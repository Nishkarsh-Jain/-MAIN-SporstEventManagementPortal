package com.player.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.player.entity.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	
	Player findByPlayerId(Long playerId);
}
