package model;

import java.util.List;

public class ConferenceRoom {
    private String conferenceRoomId;
    private Integer capacity;
    private List<Slot> slotList;

    public ConferenceRoom(String conferenceRoomId, Integer capacity) {
        this.conferenceRoomId = conferenceRoomId;
        this.capacity = capacity;
    }

    public String getConferenceRoomId() {
        return conferenceRoomId;
    }

    public void setConferenceRoomId(String conferenceRoomId) {
        this.conferenceRoomId = conferenceRoomId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }
}
