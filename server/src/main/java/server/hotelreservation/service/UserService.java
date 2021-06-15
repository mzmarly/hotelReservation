package server.hotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.hotelreservation.Security.UserPrincipal;
import server.hotelreservation.exception.ResourceNotFoundException;
import server.hotelreservation.model.Reservation;
import server.hotelreservation.model.auth.User;
import server.hotelreservation.repository.auth.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository usersRepository;



    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = usersRepository.findByLogin(login)

                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + login)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = usersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return UserPrincipal.create(user);
    }


    public Iterable<Reservation> getUserReservations(String login){
        return usersRepository.findByLogin(login).orElseThrow().getReservations();
    }

}
