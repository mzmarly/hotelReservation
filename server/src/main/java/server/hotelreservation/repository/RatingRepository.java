package server.hotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.hotelreservation.model.Hotel;
import server.hotelreservation.model.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
}