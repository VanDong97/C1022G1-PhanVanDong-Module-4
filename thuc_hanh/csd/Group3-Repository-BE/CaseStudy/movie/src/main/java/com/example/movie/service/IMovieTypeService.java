package com.example.movie.service;

import com.example.movie.dto.MovieTypeDTO;
import com.example.movie.model.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMovieTypeService {
    Page<MovieTypeDTO> findByName(String name, Pageable pageable);
    MovieTypeDTO findById(int id);
}
