import database.BookingRepository;
import database.BuildingRepository;
import database.UserRepository;
import exception.FloorNotFoundException;
import model.User;
import service.BookingService;
import service.BuildingService;
import service.UserService;

public class Main {
    public static void main(String[] args) throws FloorNotFoundException {
        System.out.println("Welcome to Conference Booking!");

        UserRepository userRepository = new UserRepository();
        BuildingRepository buildingRepository = new BuildingRepository();
        BookingRepository bookingRepository = new BookingRepository(buildingRepository);
        UserService userService = new UserService(userRepository);
        BuildingService buildingService = new BuildingService(buildingRepository);
        BookingService bookingService = new BookingService(bookingRepository, userRepository, buildingRepository);

        User user1 = new User("u1","Sam");
        User user2 = new User("u2","Tom");

        userService.registerUser(user1);
        userService.registerUser(user2);

        buildingService.addBuilding("b1");

        buildingService.addFloor("b1","f1");
        buildingService.addFloor("b1","f2");
        buildingService.addConferenceRoom("b1","f1","c1",10);
        buildingService.addConferenceRoom("b1","f1","c2",20);

        buildingService.getAllConferenceRoomsInBuilding("b1","u1");

        bookingService.bookConference("1:3","b1","f1","c1","u1");
        bookingService.bookConference("1:3","b1","f1","c1","u2");
        bookingService.getMyBooking("u1");

//        bookingService.cancelBooking("booking_0","u1");


    }
}