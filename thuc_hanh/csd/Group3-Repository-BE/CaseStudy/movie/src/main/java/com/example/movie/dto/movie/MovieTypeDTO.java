package com.example.movie.dto.movie;

import java.util.Set;

public class MovieTypeDTO {
    private Integer id;
    private String name;

    Set<MovieDTO> movieSet;

    public MovieTypeDTO() {
    }

    public MovieTypeDTO(Integer id, String name, Set<MovieDTO> movieSet) {
        this.id = id;
        this.name = name;
        this.movieSet = movieSet;
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
