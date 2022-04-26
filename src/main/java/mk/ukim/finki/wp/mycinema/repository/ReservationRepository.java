package mk.ukim.finki.wp.mycinema.repository;

import mk.ukim.finki.wp.mycinema.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("select r from Reservation r where r.user.username = :username")
    List<Reservation> findAllByUsername(String username);
}
