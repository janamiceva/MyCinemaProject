package mk.ukim.finki.wp.mycinema.service;


import mk.ukim.finki.wp.mycinema.model.Movie;
import mk.ukim.finki.wp.mycinema.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    List<Movie> listAllMoviesInReservations(Long id);
    Reservation getActiveReservation(String username);
    Reservation addMovieInReservation(String username, Long movieId, Integer numberOfTickets, LocalDateTime dateTime);
    List<Reservation> getMyReservations();
}
