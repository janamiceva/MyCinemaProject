package mk.ukim.finki.wp.mycinema.repository;


import mk.ukim.finki.wp.mycinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByNameOrDescription(String name, String description);
    void deleteByName(String name);
}
