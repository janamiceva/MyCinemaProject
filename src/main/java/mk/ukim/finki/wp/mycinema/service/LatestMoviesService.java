package mk.ukim.finki.wp.mycinema.service;

import mk.ukim.finki.wp.mycinema.model.LatestMovies;
import mk.ukim.finki.wp.mycinema.model.Movie;

import java.util.List;

public interface LatestMoviesService {
    List<LatestMovies> findAll();
}
