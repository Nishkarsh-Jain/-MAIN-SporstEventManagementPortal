package com.sports.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sports.event.entity.Sports;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Long> {

	 Sports findBySportsName(String sportName);
}
