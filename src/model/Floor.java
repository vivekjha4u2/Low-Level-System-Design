package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private String floorId;
    private List<ConferenceRoom> conferenceRoomList = new ArrayList<>();

    public Floor() {
    }

    public Floor(String floorId, List<ConferenceRoom> conferenceRoomList) {
        this.floorId = floorId;
        this.conferenceRoomList = conferenceRoomList;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public List<ConferenceRoom> getConferenceRoomList() {
        return conferenceRoomList;
    }

    public void setConferenceRoomList(List<ConferenceRoom> conferenceRoomList) {
        this.conferenceRoomList = conferenceRoomList;
    }
}
