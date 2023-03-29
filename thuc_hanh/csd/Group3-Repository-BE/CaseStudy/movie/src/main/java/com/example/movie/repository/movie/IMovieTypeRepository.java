package com.example.movie.repository.movie;

import com.example.movie.model.movie.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieTypeRepository extends JpaRepository<MovieType,Integer> {
    Page<MovieType> findByNameContaining(String name, Pageable pageable);
    MovieType findById(int id);
}
