package com.example.movie.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String actor;
    private String director;
    private String content;
    private String country;
    @ManyToOne
    @JoinColumn(name = "movie_type_id",referencedColumnName = "id")
    @JsonBackReference
    private MovieType movieType;
    public Movie() {
    }

    public Movie(Integer id, String name, String actor, String director, String content, String country, MovieType movieType) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.director = director;
        this.content = content;
        this.country = country;
        this.movieType = movieType;
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

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
}
