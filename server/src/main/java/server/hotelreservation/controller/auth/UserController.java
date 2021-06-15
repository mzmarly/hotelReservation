package server.hotelreservation.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.model.auth.User;
import server.hotelreservation.repository.auth.UserRepository;
import server.hotelreservation.service.UserService;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    public UserController() {
    }

    @Autowired
    UserService usersService;

    @Autowired
    UserRepository userRepository;


//    @GetMapping("/user/me")
//    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
//        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
//        return userSummary;
//    }

//    @GetMapping
//    public void get

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/reservation/{login}")
    public Iterable<Reservation> getReservations(@PathVariable String login){
        return usersService.getUserReservations(login);
    }

}
