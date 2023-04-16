package database;

import Logging.ConsoleLog;
import Logging.Logger;
import exception.BuildingNotPresentException;
import exception.FloorNotFoundException;
import exception.UserAlreadyPresentException;
import model.*;

import java.util.*;

public class BuildingRepository {
    Map<String, Building> buildingMap = new HashMap<>();
    Map<String, Floor> floorMap = new HashMap<>();
    Map<String, ConferenceRoom> conferenceRoomMap = new HashMap<>();

    Logger logger = new ConsoleLog();





    public void addBuilding(String buildingId){
        Building building = new Building();
        building.setBuildingId(buildingId);
        buildingMap.put(buildingId, building);
        logger.consoleLog("Added building "+buildingId + " into the system.");
    }

    public void addFloor(String buildingId, String floorId){
        if(!buildingMap.containsKey(buildingId)){
            throw new BuildingNotPresentException();
        }
        Building building = buildingMap.get(buildingId);
        Floor floor = new Floor();
        floor.setFloorId(floorId);

        building.getFloorList().add(floor);
        logger.consoleLog("Added floor "+floorId + " in building "+buildingId);
    }

    public void addConferenceRoom(String buildingId, String floorId, String conferenceRoomId, Integer capacity) throws FloorNotFoundException {
        if(!buildingMap.containsKey(buildingId)){
            throw new BuildingNotPresentException();
        }
        Building building = buildingMap.get(buildingId);
        Optional<Floor> floor = building.getFloorList().stream()
                .filter(floor1 -> floor1.getFloorId().equals(floorId) )
                .findFirst();
        Floor myFloor;
        if(floor.isPresent()){
            myFloor = floor.get();
        }else{
            throw new FloorNotFoundException();
        }

        ConferenceRoom room = new ConferenceRoom(conferenceRoomId,capacity);

        myFloor.getConferenceRoomList().add(room);
        logger.consoleLog("Added conference room "+ room.getConferenceRoomId()
        +" on floor- "+ floorId + " in building- "+buildingId);
    }

    public List<ConferenceRoom> getAllConferenceRoom(String buildingId, String userId) {
        Building building = buildingMap.get(buildingId);
        List<ConferenceRoom> conferenceRoomList = new ArrayList<>();
        for(Floor floor: building.getFloorList()){
            for (ConferenceRoom room: floor.getConferenceRoomList()){
                conferenceRoomList.add(room);
            }
        }
        return conferenceRoomList;
    }


}
