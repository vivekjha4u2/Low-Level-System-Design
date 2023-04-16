package model;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingId;
    private List<Floor> floorList = new ArrayList<>();

    public Building() {
    }

    public Building(String buildingId, List<Floor> floorList) {
        this.buildingId = buildingId;
        this.floorList = floorList;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }
}
