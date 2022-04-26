package mk.ukim.finki.wp.mycinema.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Director director;
    private String description;
    private Long year;
    private Long price;
    private Integer favorite = 0;
    private String pictureUrl;

    @ManyToMany
    private List<Genre> genre;


    public Movie() {

    }

    public Movie(String name, String description, Director director, List<Genre> genre, Long year, Long price, String pictureUrl) {
        this.name=name;
        this.description=description;
        this.director=director;
        this.genre=genre;
        this.year=year;
        this.price=price;
        this.pictureUrl=pictureUrl;
    }

}
