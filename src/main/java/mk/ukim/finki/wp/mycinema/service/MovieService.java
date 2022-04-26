package mk.ukim.finki.wp.mycinema.service;

import mk.ukim.finki.wp.mycinema.model.Genre;
import mk.ukim.finki.wp.mycinema.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    List<Movie> findAllByNameOrDescription(String text);
    Movie delete(Long id);
    Movie save(String name, String description, Long directorId, List<Long> genreIds, Long year, Long price, String pictureUrl);
    Movie favorite(Long id);
    Movie update(Long id,String name, String description, Long directorId, List<Long> genreIds, Long year, Long price, String pictureUrl);
    Page<Movie> findPaginated(int pageNo, int pageSize);
}
