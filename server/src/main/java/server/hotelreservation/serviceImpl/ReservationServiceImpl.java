package server.hotelreservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.ReservationRepository;
import server.hotelreservation.repository.RoomRepository;
import server.hotelreservation.repository.auth.UserRepository;
import server.hotelreservation.service.ReservationService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public long getAvailableRoom(long hotelId, int size, LocalDate startDate, LocalDate endDate) {
        var rooms = hotelRepository.findById(hotelId).get().getRooms();
        AtomicLong foundRoomId = new AtomicLong(-1L);
        rooms.forEach(room -> {
            if (room.getReservations().isEmpty() && room.getSize() == size) {
                foundRoomId.set(room.getRoomId());
                return;
            }
            if (room.getSize() == size) {
                room.getReservations().forEach(reservation -> {
                    if (!(startDate.isAfter(reservation.getStartDate()) && startDate.isBefore(reservation.getEndDate()))) {
                        if (!(endDate.isAfter(reservation.getStartDate()) && endDate.isBefore(reservation.getEndDate()))) {
                            foundRoomId.set(room.getRoomId());
                            return;
                        }
                    }
                });
            }
        });
        return foundRoomId.longValue();
    }

    @Override
    public Reservation addReservation(String login,long hotelId, long roomId, LocalDate start, LocalDate end) {

        //   LocalDate start2 = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //  LocalDate end2 = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //System.out.println(start2);
        //long numberOfDays = Duration.between(start,end).toDays();
        long numberOfDays = ChronoUnit.DAYS.between(start, end);
        var room = roomRepository.findById(roomId).orElseThrow();
        var totalPrice = room.getPrice() * numberOfDays;
        var hotel = hotelRepository.findById(hotelId).orElseThrow();
        Reservation reservation = new Reservation(reservationRepository.findAll().size(),start,end,totalPrice,hotel.getCity(), room.getSize(),hotel,room);
        reservationRepository.save(reservation);
        Set<Reservation> set = userRepository.findByLogin(login).orElseThrow().getReservations();
        set.add(reservation);
        userRepository.findByLogin(login).orElseThrow().setReservations(set);
        userRepository.save(userRepository.findByLogin(login).orElseThrow());

        return reservation;
    }


}
