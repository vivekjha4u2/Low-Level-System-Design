package database;

import Logging.ConsoleLog;
import Logging.Logger;
import exception.UserAlreadyPresentException;
import model.Booking;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    Map<String, User> userMap = new HashMap<>();

    Logger logger = new ConsoleLog();
    public void registerUser(User user){
        if(userMap.containsKey(user.getUserId())){
            throw new UserAlreadyPresentException();
        }
        userMap.put(user.getUserId(), user);
        logger.consoleLog(user.getUserName() + " registered successfully.");
    }

    public User getUser(String id){
        User user = userMap.get(id);
        return user;
    }


}
