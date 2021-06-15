package server.hotelreservation.request;

import lombok.Data;

@Data
public class SignUpRequest {

    private String nameSurname;

    private String login;

    private String email;

    private String password;


}
