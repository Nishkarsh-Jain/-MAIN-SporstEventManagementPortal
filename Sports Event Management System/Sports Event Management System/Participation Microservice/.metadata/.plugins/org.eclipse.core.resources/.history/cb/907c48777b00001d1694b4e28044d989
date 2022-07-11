package com.participation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.participation.entity.Participation;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

	List<Participation> findByStatus(String status);

}
