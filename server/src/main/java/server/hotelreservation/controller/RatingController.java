package server.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.hotelreservation.model.Hotel;
import server.hotelreservation.model.Rating;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.RatingRepository;
import server.hotelreservation.service.RatingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RatingRepository ratingRepository;

@Autowired
    RatingService ratingService;

    @PostMapping("/rating/{hotelId}/{value}/{comment}")
    public Rating addRating(@PathVariable long hotelId, @PathVariable double value,@PathVariable String comment)  {

        return ratingService.addHotelRating(hotelId,value,comment);
    }

    @GetMapping("/rating/{hotelId}")
    public Set<Rating> getHotelByCity(@PathVariable long hotelId){
        return ratingService.findByHotelId(hotelId);

    }

}
