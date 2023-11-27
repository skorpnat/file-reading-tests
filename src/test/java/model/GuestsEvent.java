package model;

public class GuestsEvent {

    private String gkId;
    private String firstName;
    private String lastName;

    public String getGkId() {
        return gkId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGkId(String gkId) {
        this.gkId = gkId;
    }
}
