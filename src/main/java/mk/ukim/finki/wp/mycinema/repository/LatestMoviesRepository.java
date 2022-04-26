package mk.ukim.finki.wp.mycinema.repository;

import mk.ukim.finki.wp.mycinema.model.LatestMovies;
import mk.ukim.finki.wp.mycinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LatestMoviesRepository extends JpaRepository<LatestMovies,Long> {

}


