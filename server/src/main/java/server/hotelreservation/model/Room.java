package server.hotelreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Data
public class Room {
    @Id
    @Column(name = "room_id")
    private long roomId;

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private int size;

    @Column(name = "url")
    private String url;


    @OneToMany
    Set<Reservation> reservations;

    public Room() {
    }

    public Room(long roomId, double price, int size, String url, Set<Reservation> reservations) {
        this.roomId = roomId;
        this.price = price;
        this.size = size;
        this.url = url;
        this.reservations = reservations;
    }
}