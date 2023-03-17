package com.example.movie.dto;

import com.example.movie.model.Movie;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class MovieTypeDTO {
    private Integer id;
    private String name;
    @JsonManagedReference
    Set<MovieDTO> movieSet;

    public MovieTypeDTO() {
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

    public Set<MovieDTO> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<MovieDTO> movieSet) {
        this.movieSet = movieSet;
    }
}
