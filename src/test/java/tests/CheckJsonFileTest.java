package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class CheckJsonFileTest {

    private ClassLoader cl = CheckJsonFileTest.class.getClassLoader();

    @Test
    void jsonFileParsingImprovedTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("event.json")
        )) {

            ObjectMapper objectMapper = new ObjectMapper();
            Event newEvent = objectMapper.readValue(reader, Event.class);
            Assertions.assertEquals("E6UJ9A", newEvent.getEventId());
            Assertions.assertEquals("Rugby", newEvent.getEventName());
            Assertions.assertEquals("Sport", newEvent.getEventType());
            Assertions.assertEquals("G5HJ9BN", newEvent.getGuests().getGkId());
            Assertions.assertEquals("Sam", newEvent.getGuests().getFirstName());
            Assertions.assertEquals("Braun", newEvent.getGuests().getLastName());
        }
    }
}