package server.hotelreservation.service;

import server.hotelreservation.model.Rating;

import java.util.Date;
import java.util.Set;

public interface RatingService {

    Rating addHotelRating(long hotelId, double value, String comment);

    Set<Rating> findByHotelId(long hotelId);
}
