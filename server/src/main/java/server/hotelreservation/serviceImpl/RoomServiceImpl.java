package server.hotelreservation.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.hotelreservation.model.Room;
import server.hotelreservation.repository.RoomRepository;
import server.hotelreservation.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room getRoom(long id) {
        return roomRepository.findById(id).orElseThrow();
    }
}
