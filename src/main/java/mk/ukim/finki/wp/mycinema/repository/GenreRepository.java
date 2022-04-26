package mk.ukim.finki.wp.mycinema.repository;

import mk.ukim.finki.wp.mycinema.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
