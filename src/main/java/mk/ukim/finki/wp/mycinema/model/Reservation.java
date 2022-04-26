package mk.ukim.finki.wp.mycinema.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne
    private Movie movie;

    private LocalDateTime localDateTime;

    private Integer numberOfTickets;


    public Reservation() {

    }
}
