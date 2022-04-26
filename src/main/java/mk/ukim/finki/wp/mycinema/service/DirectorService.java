package mk.ukim.finki.wp.mycinema.service;

import mk.ukim.finki.wp.mycinema.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> findAll();
    Optional<Director> findById(Long id);
}
