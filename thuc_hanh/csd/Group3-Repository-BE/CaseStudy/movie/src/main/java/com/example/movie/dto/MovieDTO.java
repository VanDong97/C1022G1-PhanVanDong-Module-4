package com.example.movie.dto;

import com.example.movie.model.MovieType;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class MovieDTO {
    private Integer id;
    private String name;
    private String actor;
    private String director;
    private String content;
    private String country;
    @JsonBackReference
    private MovieTypeDTO movieTypeDTO;

    public MovieDTO() {
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

    public MovieTypeDTO getMovieTypeDTO() {
        return movieTypeDTO;
    }

    public void setMovieTypeDTO(MovieTypeDTO movieTypeDTO) {
        this.movieTypeDTO = movieTypeDTO;
    }
}
