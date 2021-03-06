package com.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.player.entity.Player;

@SpringBootTest
public class PlayerEntityTest {
	@InjectMocks
	Player player;

	@Test
	public void testPlayerId() {
		player.setPlayerId(1001l);
		assertEquals(player.getPlayerId(), 1001l);
	}

	@Test
	public void testPlayerName() {
		player.setPlayerName("Bob");
		assertEquals(player.getPlayerName(), "Bob");
	}

	@Test
	public void testAge() {
		player.setAge(22);

		assertEquals(player.getAge(), 22);
	}

	@Test
	public void testContactNumber() {
		player.setContactNumber("9876543210");
		assertEquals(player.getContactNumber(), "9876543210");
	}

	@Test
	public void testEmail() {
		player.setEmail("manish@gmail.com");
		assertEquals(player.getEmail(), "manish@gmail.com");
	}

	@Test
	public void testGender() {
		player.setGender("Male");
		assertEquals(player.getGender(), "Male");
	}

	@Test
	public void testSportsName() {
		player.setSportsname("Chess");
		assertEquals(player.getSportsname(), "Chess");
	}

}
