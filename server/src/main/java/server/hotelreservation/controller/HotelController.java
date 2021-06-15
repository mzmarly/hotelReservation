package server.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import server.hotelreservation.model.Hotel;
import server.hotelreservation.model.Rating;
import server.hotelreservation.model.Room;
import server.hotelreservation.model.auth.User;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.RatingRepository;
import server.hotelreservation.repository.ReservationRepository;
import server.hotelreservation.repository.RoomRepository;
import server.hotelreservation.request.SignUpRequest;
import server.hotelreservation.response.ApiResponse;
import server.hotelreservation.service.HotelService;
import server.hotelreservation.service.RatingService;
import server.hotelreservation.service.ReservationService;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/foo2")
    public List foo2() {
//        Room room = new Room();
//        room.setPrice(25);
//        room.setRoomId(10);
//        room.setSize(2);
//        room.setUrl("https://e-turysta.pl/zdjecia/galeria-glowna/maxw772maxh580/71/Osrodek-Wypoczynkowy-Star-Leba-712663.jpg?fbclid=IwAR0G1DoNSlrzXI2GNabix4Hnt7BjpROAGMCC_6dYN23mCzbw1ksI6aBC1LY");
//        Room room1 = new Room();
//        room1.setPrice(35);
//        room1.setRoomId(11);
//        room1.setSize(4);
//        room1.setUrl("https://www.facebook.com/messenger_media?thread_id=100002308059416&attachment_id=831215364162618&message_id=mid.%24cAAAAANAKY2CAN266iV6BilwcPcU1");
//        roomRepository.save(room);
//        roomRepository.save(room1);
//
//        Rating rating = new Rating();
//        rating.setComment("not good");
//        rating.setValue(2);
//        rating.setRatingId(7);
//
//        ratingRepository.save(rating);
//
//        Hotel hotel = new Hotel(3,"Cracow","ul. Szpitalna 3", 2 ,"https://katowice24.info/wp-content/uploads/2020/04/Hotel_Katowice.jpg?fbclid=IwAR1a86oBJW9SF55Y-I7fAJSME1pEUD4HwwSIoNqs2p0GG3Km6zuElL9Hg4k", Set.of(room,room1), Set.of(rating));
        Room room  =  roomRepository.findById(6L).orElseThrow();
        //room.setSize(4);
        room.setUrl("https://images.pexels.com/photos/892618/pexels-photo-892618.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        room.setPrice(200);
        // var hotel = hotelRepository.findById(0L);
        // hotel.get().getRooms()
        //hotelRepository.save();
        // roomRepository.save(room);
        return hotelRepository.findAll();
    }

    @GetMapping("/foo3")
    public String foo3() {
        return "foo";
    }


    @GetMapping("/hotels/{city}")
    public List<Hotel> getHotelByCity(@PathVariable String city){
        return hotelRepository.findAllByCity(city).orElseThrow();

    }

    @GetMapping("/hotel/{id}")
    public Hotel getHotel(@PathVariable long id){
        return hotelRepository.findById(id).orElseThrow();
    }

    @GetMapping("/hotelR/{id}")
    public double getHotelR(@PathVariable long id){
        return hotelService.getAvgRating(id);
    }
}
