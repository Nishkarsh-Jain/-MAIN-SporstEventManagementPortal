package com.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerController {

	PlayerController playerController = new PlayerController();

	@Test
	@DisplayName("Checking for EmployeeController - if it is loading or not for @GetMapping")
	void playerControllerNotNullTest() {
		assertThat(playerController).isNotNull();
	}
}
