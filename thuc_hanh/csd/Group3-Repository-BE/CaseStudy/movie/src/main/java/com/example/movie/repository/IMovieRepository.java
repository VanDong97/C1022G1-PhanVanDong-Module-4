package com.example.movie.repository;

import com.example.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {
    Page<Movie> findByNameContaining(String name, Pageable pageable);
    Movie findById(int id);
}
