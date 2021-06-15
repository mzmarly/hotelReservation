package server.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.hotelreservation.model.Room;
import server.hotelreservation.service.RoomService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/room/{id}")
    public Room room(@PathVariable long id) {
        return roomService.getRoom(id);
    }
}
