package server.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.RoomRepository;
import server.hotelreservation.service.HotelService;
import server.hotelreservation.service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    RoomRepository roomRepository;


    @GetMapping("/freeRoom/{hotelId}/{size}/{start}/{end}")
    public Long freeRoom(@PathVariable long hotelId, @PathVariable int size, @PathVariable String start, @PathVariable String end) throws ParseException {
       // SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        //System.out.println(start);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return reservationService.getAvailableRoom(hotelId, size, startDate, endDate);
    }

    @PostMapping("/reservation/{login}/{hotelId}/{roomId}/{start}/{end}")
    public Reservation reservation(@PathVariable String login,@PathVariable long hotelId, @PathVariable long roomId, @PathVariable String start, @PathVariable String end) throws ParseException {
       // SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        return reservationService.addReservation(login,hotelId, roomId, startDate, endDate);
    }



}
