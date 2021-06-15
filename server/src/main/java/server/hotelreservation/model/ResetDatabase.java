package server.hotelreservation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.hotelreservation.repository.HotelRepository;
import server.hotelreservation.repository.RatingRepository;
import server.hotelreservation.repository.ReservationRepository;
import server.hotelreservation.repository.RoomRepository;
import server.hotelreservation.service.RatingService;
import server.hotelreservation.service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ResetDatabase {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    RatingService ratingService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("/reset")
    public void reset() throws ParseException {

        hotelRepository.deleteAllInBatch();
        reservationRepository.deleteAllInBatch();
        ratingRepository.deleteAllInBatch();
        roomRepository.deleteAllInBatch();


        Room room = new Room(0L,250,4,"https://images.unsplash.com/photo-1513694203232-719a280e022f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cm9vbXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80",null);
        Room room2 = new Room(1L,150,2,"https://www.thespruce.com/thmb/EvdqR5HNV6Ev9RBv8qGqHNE8DoM=/3636x2045/smart/filters:no_upscale()/how-to-arrange-living-room-furniture-1976578-hero-c99074dcad854b669b91652046a39203.jpg",null);
        Room room3 = new Room(2L,200,2,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/small-living-rooms-bungalow-etna-nook-029-1608661123.jpg",null);
        Room room4 = new Room(3L,150,2,"https://images.unsplash.com/photo-1554995207-c18c203602cb?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cm9vbXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80",null);
        Room room5 = new Room(4L,200,4,"https://images.pexels.com/photos/892618/pexels-photo-892618.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",null);
        Room room6 = new Room(5L,150,2,"https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bGl2aW5nJTIwcm9vbXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80",null);
        Room room7 = new Room(6L,250,4,"https://www.beautifulhomes.com/content/dam/beautifulhomes/images/202001/a-simple-guide-for-decorating-your-living-room/Title-Living-room-.jpg",null);
        Room room8 = new Room(7L,150,2,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/edc-mark-cunningham-trends-2living-room-1608147086.jpg",null);
        Room room9 = new Room(8L,300,4,"https://media.architecturaldigest.in/wp-content/uploads/2020/04/Living-room-design-for-more-space-1366x768.jpg",null);
        Room room10 = new Room(9L,100,2,"https://empire-s3-production.bobvila.com/pages/538/original/Bedroom.jpg?1310503752",null);

        Room room11 = new Room(10L,350,2,"https://www.hiltonhotels.com/assets/img/Hotel%20Images/DoubleTree/K/KRKCCDI/KRKCCDI_quicklook_full_kingguestroom001.jpg",null);
        Room room12= new Room(11L,400,4,"https://content.r9cdn.net/rimg/himg/96/cd/29/ice-66382-65737485_3XL-944085.jpg?width=660&height=400&xhint=1497&yhint=788&crop=true&outputtype=webp",null);
        Room room13 = new Room(12L,300,2,"https://www.salebiznesowe.pl/media/news/news1551/doubletree-by-hilton-room.jpg",null);


        Room room14 = new Room(13L,250,2,"https://s5s6c2i4.stackpathcdn.com/wp-content/uploads/2019/10/Baglioni-Hotel-London-Junior-Suite-Executive-Park-View-2-1.jpg",null);
        Room room15 = new Room(14L,350,4,"https://cf.bstatic.com/images/hotel/max1280x900/223/223976695.jpg",null);
        Room room16 = new Room(15L,150,2,"https://s5s6c2i4.stackpathcdn.com/wp-content/uploads/2018/06/6_Luna_Hotel_Baglioni_Superior_Room.jpg",null);

        roomRepository.save(room);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);
        roomRepository.save(room5);
        roomRepository.save(room6);
        roomRepository.save(room7);
        roomRepository.save(room8);
        roomRepository.save(room9);
        roomRepository.save(room10);

        roomRepository.save(room11);
        roomRepository.save(room12);
        roomRepository.save(room13);

        roomRepository.save(room14);
        roomRepository.save(room15);
        roomRepository.save(room16);


        Rating rating1 = new Rating(0L,6,"Good food, but very noisy.");
        Rating rating2 = new Rating(1L,7,"Very nice, I like.");
        Rating rating3 = new Rating(2L,8,"Friendly staff, comfy beds.");
        Rating rating4 = new Rating(3L,0,"We had dirty sheets...");
        Rating rating5 = new Rating(4L,7,"Alright I guess");
        Rating rating6 = new Rating(5L,10,"Best hotel ever!");
        Rating rating7 = new Rating(6L,10,"Cracow very beautiful.");

        Rating rating8 = new Rating(7L,10,"High quality of service");
        Rating rating9 = new Rating(8L,10,"Incredibly beautiful");
        Rating rating10 = new Rating(9L,10,"Delicious food and amazing comfort of the rooms");

        Rating rating11 = new Rating(10L,7,"luxury and wealth but rude service");
        Rating rating12 = new Rating(11L,10,"Greate!!");

        ratingRepository.save(rating1);
        ratingRepository.save(rating2);
        ratingRepository.save(rating3);
        ratingRepository.save(rating4);
        ratingRepository.save(rating5);
        ratingRepository.save(rating6);
        ratingRepository.save(rating7);

        ratingRepository.save(rating8);
        ratingRepository.save(rating9);
        ratingRepository.save(rating10);

        ratingRepository.save(rating11);
        ratingRepository.save(rating12);

        Hotel hotel = new Hotel(0L,"Hotel Sopot","Sopot", "Piaszczysta 7", 5,"https://u.profitroom.pl/2017.hotelsopot.eu/thumb/1920x1080/uploads/HS_foto.jpg", Set.of(room5,room6,room7),Set.of(rating2, rating1));
        Hotel hotel2 = new Hotel(1L,"Euro Hotel","London", "Times Square 66", 5,"https://u.profitroom.pl/2019-europeum-pl/thumb/2560x1440/uploads/Fasada_1920_1080.jpg",Set.of(room8,room9,room10),Set.of(rating5, rating4,rating3));
        Hotel hotel3 = new Hotel(2L,"l Hotel","Cracow", "Westerplatte 15", 3,"https://pix10.agoda.net/hotelImages/124/1246280/1246280_16061017110043391702.jpg?s=1024x768",Set.of(room,room2,room3,room4),Set.of(rating7, rating6));

        Hotel hotel4 = new Hotel(3L,"Hilton","Cracow", "Aleja Pokoju 50", 5,"https://www.konferencje.pl/media/cache/slideshow_v2/n/k/H/4/nkH4IwRxcNqBrUWs6JSZ.jpeg",Set.of(room11,room12,room13),Set.of(rating8, rating9,rating10));
        Hotel hotel5 = new Hotel(4L,"Bagiloni Hotel","London", "Hyde Park", 4,"https://cdn4.hotelopia.com/giata/bigger/01/015155/015155a_hb_a_001.jpg",Set.of(room14,room15,room16),Set.of(rating11, rating12));

        hotelRepository.save(hotel);
        hotelRepository.save(hotel2);
        hotelRepository.save(hotel3);
        hotelRepository.save(hotel4);
        hotelRepository.save(hotel5);


        //String startDateStr="24.03.2021";
        String startDateStr="2021-03-24";
        //String endDateStr="07.07.2021";
        String endDateStr="2021-07-07";
       // SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        Reservation reservation1 = new Reservation(0L, startDate,endDate, 8790, "Cracow", 4, hotel3, room);
        reservationRepository.save(reservation1);

        roomRepository.getById(Integer.toUnsignedLong(0)).reservations=Set.of(reservation1);
    }
}
