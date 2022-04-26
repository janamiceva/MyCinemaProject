package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.Genre;
import mk.ukim.finki.wp.mycinema.repository.GenreRepository;
import mk.ukim.finki.wp.mycinema.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return this.genreRepository.findAll();
    }
}
