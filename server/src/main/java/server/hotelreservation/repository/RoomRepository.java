package server.hotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import server.hotelreservation.model.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}