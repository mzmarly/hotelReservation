package server.hotelreservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.hotelreservation.model.Rating;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.service.HotelService;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public double getAvgRating(long id) {
        var hotel = hotelRepository.findById(id);
        double avg = 0.;
        for (Rating i : hotel.get().getRatings()) {
            avg += i.getValue();
        }
        return avg / hotel.get().getRatings().size();
    }
}
