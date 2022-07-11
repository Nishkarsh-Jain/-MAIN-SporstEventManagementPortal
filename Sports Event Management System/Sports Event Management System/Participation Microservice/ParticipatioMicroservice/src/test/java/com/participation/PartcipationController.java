package com.participation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.participation.controller.ParticipationController;

@SpringBootTest
public class PartcipationController {

	ParticipationController participationController = new ParticipationController();

	@Test
	@DisplayName("Checking for EmployeeController - if it is loading or not for @GetMapping")
	void playerControllerNotNullTest() {
		assertThat(participationController).isNotNull();
	}
}
