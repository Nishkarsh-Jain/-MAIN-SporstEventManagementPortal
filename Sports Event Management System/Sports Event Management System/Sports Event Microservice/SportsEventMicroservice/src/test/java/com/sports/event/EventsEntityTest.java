package com.sports.event;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import com.sports.event.entity.Events;


@SpringBootTest
public class EventsEntityTest {

	@InjectMocks 
	Events events;

	@Test
	public void testEventsId() {
		events.setEventId(1001l);
		assertEquals(events.getEventId(), 1001l);
	}

	@Test
	public void testEventDate() {
		events.setEventDate("10/07/2022");
		assertEquals(events.getEventDate(), "10/07/2022");
	}

	@Test
	public void testEventName() {
		events.setEventName("Crirket");
		assertEquals(events.getEventName(), "Cricket");
	}

	@Test
	public void testNoofSlots() {
		events.setNoofSlots(22);
		assertEquals(events.getNoofSlots(), 22);
	}

	@Test
	public void testSportsName() {
		events.setSportsName("Chess");
		assertEquals(events.getSportsName(), "Chess");
	}

}
