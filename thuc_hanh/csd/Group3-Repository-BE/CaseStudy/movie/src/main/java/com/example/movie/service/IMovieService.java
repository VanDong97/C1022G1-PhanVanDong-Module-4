package com.example.movie.service;

import com.example.movie.dto.MovieDTO;
import com.example.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieService {
    Page<MovieDTO> findByName(String name, Pageable pageable);
    MovieDTO findById(int id);
    void save(Movie movie);
}
