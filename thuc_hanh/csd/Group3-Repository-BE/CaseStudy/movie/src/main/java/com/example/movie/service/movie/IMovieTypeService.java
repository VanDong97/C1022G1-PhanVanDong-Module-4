package com.example.movie.service.movie;

import com.example.movie.dto.movie.MovieTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMovieTypeService {
    Page<MovieTypeDTO> findByName(String name, Pageable pageable);

    MovieTypeDTO findById(int id);
}
