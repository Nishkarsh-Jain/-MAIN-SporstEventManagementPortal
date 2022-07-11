package com.sports.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sports.event.controller.SportsEventController;

@SpringBootTest
public class SportsEventControllerTest {

	SportsEventController sportsEventController = new SportsEventController();

	@Test
	@DisplayName("Checking for EmployeeController - if it is loading or not for @GetMapping")
	void playerControllerNotNullTest() {
		assertThat(sportsEventController).isNotNull();
	}

}
