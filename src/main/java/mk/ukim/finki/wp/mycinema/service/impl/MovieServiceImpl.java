package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.Director;
import mk.ukim.finki.wp.mycinema.model.Genre;
import mk.ukim.finki.wp.mycinema.model.Movie;
import mk.ukim.finki.wp.mycinema.model.exceptions.DirectorNotFoundException;
import mk.ukim.finki.wp.mycinema.model.exceptions.GenreNotFoundException;
import mk.ukim.finki.wp.mycinema.model.exceptions.MovieNotFoundException;
import mk.ukim.finki.wp.mycinema.repository.DirectorRepository;
import mk.ukim.finki.wp.mycinema.repository.GenreRepository;
import mk.ukim.finki.wp.mycinema.repository.MovieRepository;
import mk.ukim.finki.wp.mycinema.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, DirectorRepository directorRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Movie> findAll() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return this.movieRepository.findById(id).orElseThrow(()-> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> findAllByNameOrDescription(String text) {
        return this.movieRepository.findAllByNameOrDescription(text,text);
    }

    @Override
    public Movie delete(Long id) {
        Movie movie=this.findById(id);
        this.movieRepository.delete(movie);
        return movie;
    }

    @Override
    public Movie save(String name, String description, Long directorId, List<Long> genreIds, Long year, Long price, String pictureUrl) {
        List<Genre> genres=this.genreRepository.findAllById(genreIds);
        Director director=this.directorRepository.findById(directorId).get();
        Movie m=new Movie(name,description,director,genres,year,price,pictureUrl);
        return this.movieRepository.save(m);
    }

    @Override
    public Movie update(Long id,String name, String description, Long directorId, List<Long> genreIds, Long year, Long price, String pictureUrl) {
        Movie m=this.findById(id);
        List<Genre> genres=this.genreRepository.findAllById(genreIds);
        Director director=this.directorRepository.findById(directorId).get();
        m.setName(name);
        m.setDescription(description);
        m.setDirector(director);
        m.setGenre(genres);
        m.setYear(year);
        m.setPictureUrl(pictureUrl);
        m.setPrice(price);
        return this.movieRepository.save(m);
    }



    @Override
    public Movie favorite(Long id) {
        Movie movie=this.findById(id);
        movie.setFavorite(movie.getFavorite()+1);
        return this.movieRepository.save(movie);
    }

    @Override
    public Page<Movie> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        return this.movieRepository.findAll(pageable);
    }


}
