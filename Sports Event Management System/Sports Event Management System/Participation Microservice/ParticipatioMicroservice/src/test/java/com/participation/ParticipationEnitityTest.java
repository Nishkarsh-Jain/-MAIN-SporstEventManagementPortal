package com.participation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.participation.entity.Participation;

@SpringBootTest
public class ParticipationEnitityTest {

	@InjectMocks
	Participation participation;

	@Test
	public void testparticipationId() {
		participation.setParticipationId(1001l);
		assertEquals(participation.getParticipationId(), 1001l);
	}

	@Test
	public void testplayerId() {
		participation.setPlayerId(1001l);
		assertEquals(participation.getPlayerId(), 1001l);
	}

	@Test
	public void testPlayerName() {
		participation.setPlayerName("Raj");

		assertEquals(participation.getPlayerName(), "Raj");
	}

	@Test
	public void testEventId() {
		participation.setEventId(987l);
		assertEquals(participation.getEventId(), 987l);
	}

	@Test
	public void testEventName() {
		participation.setEventName("cricket");
		assertEquals(participation.getEventName(), "cricket");
	}

	@Test
	public void testSportId() {
		participation.setSportsId(4510l);
		assertEquals(participation.getSportsId(), 4510l);
	}

	@Test
	public void testSportsName() {
		participation.setSportsName("Chess");
		assertEquals(participation.getSportsName(), "Chess");
	}
}
