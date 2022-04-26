package mk.ukim.finki.wp.mycinema.web;

import mk.ukim.finki.wp.mycinema.model.*;
import mk.ukim.finki.wp.mycinema.service.DirectorService;
import mk.ukim.finki.wp.mycinema.service.GenreService;
import mk.ukim.finki.wp.mycinema.service.LatestMoviesService;
import mk.ukim.finki.wp.mycinema.service.MovieService;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final LatestMoviesService latestMoviesService;
    private final DirectorService directorService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, LatestMoviesService latestMoviesService, DirectorService directorService, GenreService genreService) {
        this.movieService = movieService;
        this.latestMoviesService = latestMoviesService;
        this.directorService = directorService;
        this.genreService = genreService;
    }

    @GetMapping({"/","/home"})
    public String showHomePage(Model model){
        List<LatestMovies> movies=this.latestMoviesService.findAll();
        model.addAttribute("movies",movies);
        return "home.html";
    }


    @GetMapping("/movies")
    public String showMovies(@RequestParam(required = false) String name, @RequestParam(required = false) Genre genre,
                             @RequestParam(required = false) String director, Model model, HttpServletRequest request) {
        return findPaginated(1,model, request);
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact.html";
    }

    @GetMapping("/news")
    public String showNewsPage() {
        return "news.html";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model, HttpServletRequest request){
        User user = null;
        try{
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception ignored){

        }
        int pageSize = 3;

        Page<Movie> page=movieService.findPaginated(pageNo,pageSize);
        List<Movie> listMovies = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("movies",listMovies);
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "movies.html";
    }

    @PostMapping("/movies/{id}/delete")
    public String deleteMovie(@PathVariable Long id)
    {
        this.movieService.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/add")
    public String showAdd(Model model) {
        List<Genre> genres=this.genreService.findAll();
        model.addAttribute("genres",genres);
        List<Director> directors=this.directorService.findAll();
        model.addAttribute("directors",directors);
        return "add-movie.html";
    }

    @GetMapping("/movies/{id}/edit")
    public String showEdit(@PathVariable Long id,Model model) {
        Movie movie=this.movieService.findById(id);
        model.addAttribute("movie",movie);
        List<Genre> genres=this.genreService.findAll();
        model.addAttribute("genres",genres);
        List<Director> directors=this.directorService.findAll();
        model.addAttribute("directors",directors);
        return "add-movie.html";
    }


    @PostMapping("/movies")
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam Long directors,
                         @RequestParam List<Long> genres,
                         @RequestParam Long year,
                         @RequestParam Long price,
                         @RequestParam String pictureUrl) {
        this.movieService.save(name, description, directors, genres,year,price,pictureUrl);
        return "redirect:/movies";
    }

    @PostMapping("/movies/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam Long directors,
                         @RequestParam List<Long> genres,
                         @RequestParam Long year,
                         @RequestParam Long price,
                         @RequestParam String pictureUrl) {
        this.movieService.update(id, name, description, directors, genres,year,price,pictureUrl);
        return "redirect:/movies";
    }

}
