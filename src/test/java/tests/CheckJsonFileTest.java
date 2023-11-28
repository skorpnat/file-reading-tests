package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckJsonFileTest {

    private ClassLoader cl = CheckJsonFileTest.class.getClassLoader();

    @Test
    void jsonFileParsingImprovedTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("event.json")
        )) {

            ObjectMapper objectMapper = new ObjectMapper();
            Event newEvent = objectMapper.readValue(reader, Event.class);
            assertThat(newEvent.getEventId()).isEqualTo("E6UJ9A");
            assertThat(newEvent.getEventName()).isEqualTo("Rugby");
            assertThat(newEvent.getEventType()).isEqualTo("Sport");
            assertThat(newEvent.getGuests().getGkId()).isEqualTo("G5HJ9BN");
            assertThat(newEvent.getGuests().getFirstName()).isEqualTo("Sam");
            assertThat(newEvent.getGuests().getLastName()).isEqualTo("Braun");
        }
    }
}