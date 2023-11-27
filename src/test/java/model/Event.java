package model;

public class Event {

    private String eventId;
    private String eventName;
    private String eventType;

    private GuestsEvent guests;

    public GuestsEvent getGuests() {
        return guests;
    }

    public void setGuests(GuestsEvent guests) {
        this.guests = guests;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventType() {
        return eventType;
    }



    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
