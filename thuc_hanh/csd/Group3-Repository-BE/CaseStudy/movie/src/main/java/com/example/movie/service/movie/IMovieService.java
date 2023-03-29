package com.example.movie.service.movie;

import com.example.movie.dto.movie.MovieDTO;
import com.example.movie.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMovieService {
    Page<MovieDTO> findByName(String name, Pageable pageable);
    MovieDTO findById(int id);
    void save(Movie movie);
    void edit(Movie movie);
    Page<MovieDTO> findMoving(String name, Pageable pageable);
    Page<MovieDTO> upComingMovie(String name, Pageable pageable);
    void deleteMovie(int id);
}
