package server.hotelreservation.service;

import server.hotelreservation.model.Reservation;

import java.time.LocalDate;
import java.util.Date;

public interface ReservationService {

    long getAvailableRoom(long hotelId, int size, LocalDate start, LocalDate end);


    Reservation addReservation(String login, long hotelId, long roomId, LocalDate start, LocalDate end);

}