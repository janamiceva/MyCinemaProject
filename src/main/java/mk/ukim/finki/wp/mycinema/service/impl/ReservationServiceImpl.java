package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.Movie;
import mk.ukim.finki.wp.mycinema.model.Reservation;
import mk.ukim.finki.wp.mycinema.model.ReservationStatus;
import mk.ukim.finki.wp.mycinema.model.User;
import mk.ukim.finki.wp.mycinema.repository.MovieRepository;
import mk.ukim.finki.wp.mycinema.repository.ReservationRepository;
import mk.ukim.finki.wp.mycinema.repository.UserRepository;
import mk.ukim.finki.wp.mycinema.service.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, MovieRepository movieRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAllMoviesInReservations(Long id) {
        return  movieRepository.findAll();
    }

    @Override
    public Reservation getActiveReservation(String username) {
        return null;
    }

    @Override
    public Reservation addMovieInReservation(String username, Long movieId, Integer numberOfTickets, LocalDateTime dateTime) {
        Reservation reservation = new Reservation();
        reservation.setUser(userRepository.getById(username));
        reservation.setStatus(ReservationStatus.CREATED);
        reservation.setMovie(movieRepository.getById(movieId));
        reservation.setNumberOfTickets(numberOfTickets);
        reservation.setLocalDateTime(dateTime);
        return reservationRepository.saveAndFlush(reservation);
    }

    @Override
    public List<Reservation> getMyReservations() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = (User) auth.getPrincipal();
        return reservationRepository.findAllByUsername(loggedInUser.getUsername());
    }
}
