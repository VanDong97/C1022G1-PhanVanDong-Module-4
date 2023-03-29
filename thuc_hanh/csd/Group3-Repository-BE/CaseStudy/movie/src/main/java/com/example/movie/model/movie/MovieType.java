package com.example.movie.model.movie;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "movie_type")
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "movieType")
    Set<Movie> movieSet;

    public MovieType(Integer id, String name, Set<Movie> movieSet) {
        this.id = id;
        this.name = name;
        this.movieSet = movieSet;
    }

    public MovieType(Integer id) {
        this.id = id;
    }

    public MovieType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movieSet = movieSet;
    }
}
