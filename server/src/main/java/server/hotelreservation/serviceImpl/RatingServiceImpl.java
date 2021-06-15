package server.hotelreservation.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.hotelreservation.model.Rating;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.RatingRepository;
import server.hotelreservation.service.RatingService;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating addHotelRating(long hotelId, double value, String comment) {
        long raitingId=ratingRepository.findAll().size();
        var hotel = hotelRepository.findById(hotelId).orElseThrow();
        Rating rating= new Rating(raitingId,value,comment);
        ratingRepository.save(rating);
        Set<Rating> ratings=hotel.getRatings();
        ratings.add(rating);
        hotel.setRatings(ratings);
        hotel.getRatings().add(rating);
        hotelRepository.save(hotel);
        return rating;
    }

    @Override
    public Set<Rating> findByHotelId(long hotelId) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow();
        return hotel.getRatings();
    }
}

