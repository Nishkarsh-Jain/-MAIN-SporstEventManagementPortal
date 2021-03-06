package com.sports.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.sports.event.entity.Sports;

@SpringBootTest
public class SportsEntityTest {

	@InjectMocks
	Sports sports;

	@Test
	public void testSportsId() {
		sports.setSportsId(1001l);
		assertEquals(sports.getSportsId(), 1001l);
	}

	@Test
	public void testSportsName() {
		sports.setSportsName("Chess");
		assertEquals(sports.getSportsName(), "Chess");
	}

	@Test
	public void testNoOfPlayers() {
		sports.setNoOfPlayers(22);

		assertEquals(sports.getNoOfPlayers(), 22);
	}

	@Test
	public void testSportsType() {
		sports.setSportsType("Chess");
		assertEquals(sports.getSportsType(), "Chess");
	}

}
