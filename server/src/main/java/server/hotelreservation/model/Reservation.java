package server.hotelreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    private long reservationId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "city")
    private String city;

    @Column(name = "size")
    private int size;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Room room;


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "reservation_rooms",
//            joinColumns = @JoinColumn(name = "reservation_id"),
//            inverseJoinColumns = @JoinColumn(name = "room_id"))
//    private Set<Room> rooms = new HashSet<>();


    public Reservation() {
    }

    public Reservation(long reservationId, LocalDate startDate, LocalDate endDate, double totalPrice, String city,int size, Hotel hotel, Room room) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.city = city;
        this.size = size;
        this.hotel = hotel;
        this.room = room;
    }
}
