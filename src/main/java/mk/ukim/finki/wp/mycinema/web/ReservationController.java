package mk.ukim.finki.wp.mycinema.web;

import mk.ukim.finki.wp.mycinema.model.User;
import mk.ukim.finki.wp.mycinema.service.MovieService;
import mk.ukim.finki.wp.mycinema.service.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final MovieService movieService;

    public ReservationController(ReservationService reservationService, MovieService movieService) {
        this.reservationService = reservationService;
        this.movieService = movieService;
    }

    @GetMapping("/reservation/{id}")
    public String getReserveMoviePage(@PathVariable long id, Model model){
        model.addAttribute("selectedMovie", movieService.findById(id));
        return "reserve.html";
    }

    @PostMapping("/reservation/{id}")
    public String createReservation(@PathVariable Long id, @RequestParam String date, @RequestParam Integer numberOfTickets){
//        model.addAttribute("selectedMovie", movieService.findById(id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = (User) auth.getPrincipal();
        LocalDate localDate = LocalDate.parse(date);
        reservationService.addMovieInReservation(loggedInUser.getUsername(), id, numberOfTickets, LocalDateTime.of(localDate, LocalTime.of(0,0)));
        return "redirect:/myreservations";
    }

    @GetMapping("/myreservations")
    public String getMyReservations(Model model){
        model.addAttribute("myReservations", reservationService.getMyReservations());
        return "myReservations.html";
    }
}
