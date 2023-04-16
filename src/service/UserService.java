package service;

import database.BookingRepository;
import database.UserRepository;
import model.Booking;
import model.Slot;
import model.User;
import util.Utility;

public class UserService {
    private UserRepository userRepository;

    //register
    public void registerUser(User user){
        userRepository.registerUser(user);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
