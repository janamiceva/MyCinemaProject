package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.LatestMovies;
import mk.ukim.finki.wp.mycinema.repository.LatestMoviesRepository;
import mk.ukim.finki.wp.mycinema.service.LatestMoviesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatestMoviesServiceImpl implements LatestMoviesService {
    private final LatestMoviesRepository latestMoviesRepository;

    public LatestMoviesServiceImpl(LatestMoviesRepository latestMoviesRepository) {
        this.latestMoviesRepository = latestMoviesRepository;
    }

    @Override
    public List<LatestMovies> findAll() {
        return this.latestMoviesRepository.findAll();
    }
}
