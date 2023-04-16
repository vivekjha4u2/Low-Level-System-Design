package service;

import Logging.ConsoleLog;
import Logging.Logger;
import database.BuildingRepository;
import exception.FloorNotFoundException;
import model.Building;
import model.ConferenceRoom;

import java.util.List;

public class BuildingService {
    private BuildingRepository buildingRepository;

    Logger logger = new ConsoleLog();
    static int buildingId;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository= buildingRepository;
    }

    //add building
    public void addBuilding( ){
        buildingRepository.addBuilding("B"+ buildingId++);
    }
    //add building
    public void addBuilding(String id ){
        buildingRepository.addBuilding(id);
    }

    //floor
    public void addFloor(String buildingId, String floorId){
        buildingRepository.addFloor(buildingId,floorId);
    }
    //c.room
    public void addConferenceRoom(String buildingId, String floorId, String conferenceRoomId, Integer capacity) throws FloorNotFoundException {
        buildingRepository.addConferenceRoom(buildingId,floorId,conferenceRoomId,capacity);
    }

    //listDown all conference rooms in a building
    public void getAllConferenceRoomsInBuilding(String buildingId, String userId){
        List<ConferenceRoom> conferenceRoomList = buildingRepository.getAllConferenceRoom(buildingId,userId);

        logger.consoleLog("List of conference rooms: ");
        for(ConferenceRoom room: conferenceRoomList){
            logger.consoleLog(room.getConferenceRoomId());
        }
    }

}
