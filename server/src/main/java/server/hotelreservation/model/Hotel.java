package server.hotelreservation.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotels")
@Data
public class Hotel {
    @Id
    @Column(name = "hotel_id")
    private long hotelId;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;


    @Column(name = "street")
    private String street;

    @Column(name = "stars")
    private int stars;

//    @Column(name = "raiting")
//    private Rating rating;

    @Column(name = "url")
    private String url;


    @OneToMany
    Set<Room> rooms = new HashSet<>();

    @OneToMany
    Set<Rating> ratings;
    public Hotel() {
    }

    public Hotel(long hotelId, String name, String city, String street, int stars, String url, Set<Room> rooms, Set<Rating> ratings) {
        this.hotelId = hotelId;
        this.name = name;
        this.city = city;
        this.street = street;
        this.stars = stars;
        this.url = url;
        this.rooms = rooms;
        this.ratings = ratings;
    }
}
