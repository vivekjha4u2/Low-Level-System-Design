package database;

import Logging.ConsoleLog;
import Logging.Logger;
import exception.FloorNotFoundException;
import exception.NoSuchBookingFoundException;
import exception.SlotAlreadyBookedException;
import model.*;

import java.util.*;

public class BookingRepository {

    Map<String, Booking> bookingMap = new HashMap<>();
    Map<String, List<Booking>> userBookingMap = new HashMap<>();
    Logger logger = new ConsoleLog();
    BuildingRepository buildingRepository;
    static int id=1;



    public String bookConference(Slot timeslot, String buildingId, String floorId, String roomId, User user) throws FloorNotFoundException {
        boolean available= checkAvailability(timeslot,buildingId,floorId,roomId,user);
        if(!available){
            throw new SlotAlreadyBookedException();
        }
        Booking booking = new Booking();
        booking.setBookingId("booking_"+ id++);
        Building building = buildingRepository.buildingMap.get(buildingId);

        Optional<Floor> floor = building.getFloorList().stream()
                .filter(floor1 -> floor1.getFloorId().equals(floorId) )
                .findFirst();
        Floor myFloor;
        if(floor.isPresent()){
            myFloor = floor.get();
        }else{
            throw new FloorNotFoundException();
        }

        ConferenceRoom room = myFloor.getConferenceRoomList().stream().filter(c->c.getConferenceRoomId().equals(roomId)).findFirst().get();
        booking.setRoom(room);
        booking.setSlot(timeslot);
        booking.setUser(user);
        bookingMap.put(booking.getBookingId(), booking);

        if(!userBookingMap.containsKey(user.getUserId())){
            userBookingMap.put(user.getUserId(), new ArrayList<>());
        }
        userBookingMap.get(user.getUserId()).add(booking);

        logger.consoleLog(user.getUserId()+" booked conference room "+ roomId+ " bookingId is "+booking.getBookingId() );
        return booking.getBookingId();
    }

    private boolean checkAvailability(Slot timeslot, String buildingId, String floorId, String roomId, User user) {

        return true;
    }

    public BookingRepository(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }


    public void cancelBooking(String bookingId, String userId) {
        if(!bookingMap.containsKey(bookingId)){
            throw new NoSuchBookingFoundException();
        }
        Booking booking = bookingMap.get(bookingId);
        User user = booking.getUser();
        //check if same user has booked
        bookingMap.remove(bookingId);
        logger.consoleLog("User " +userId+ "cancelled the Booking "+bookingId+ ".");
    }

    public void getMyBooking(String userId) {
        List<Booking> bookings = userBookingMap.get(userId);
        logger.consoleLog("All bookings of user "+userId+"are ");
        for(Booking booking:bookings){
            logger.consoleLog(booking.getBookingId());
        }
    }
}
