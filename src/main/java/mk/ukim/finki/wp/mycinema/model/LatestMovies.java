package mk.ukim.finki.wp.mycinema.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LatestMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Director director;

    private String description;
    private Long year;
    private Long price;
    private Integer favorite = 0;
    private String pictureUrl;


    public LatestMovies(String name, String description, Director director) {
        this.name=name;
        this.description=description;
        this.director=director;
    }

    public LatestMovies() {

    }
}
