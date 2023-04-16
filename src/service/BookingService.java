package service;

import database.BookingRepository;
import database.BuildingRepository;
import database.UserRepository;
import exception.FloorNotFoundException;
import model.Slot;
import model.User;
import util.Utility;

public class BookingService {

    BookingRepository bookingRepository;
    UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, BuildingRepository buildingRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    //book a conference room
    public void bookConference(String timeslot, String buildingId, String floorId, String roomId, String userId) throws FloorNotFoundException {
        Slot slot = Utility.convertStringToSlot(timeslot);
        //checkIfAvailable

        User user = userRepository.getUser(userId);
        bookingRepository.bookConference(slot,buildingId,floorId,roomId,user);
    }

    public void cancelBooking(String bookingId, String userId){
        bookingRepository.cancelBooking(bookingId, userId);
    }

    public void getMyBooking(String userId){
        bookingRepository.getMyBooking(userId);
    }
}
