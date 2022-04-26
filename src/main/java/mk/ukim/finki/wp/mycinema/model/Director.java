package mk.ukim.finki.wp.mycinema.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Director {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private String address;

}
