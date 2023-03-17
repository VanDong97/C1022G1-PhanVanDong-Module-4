package com.example.movie.repository;

import com.example.movie.model.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieTypeRepository extends JpaRepository<MovieType,Integer> {
    Page<MovieType> findByNameContaining(String name, Pageable pageable);
    MovieType findById(int id);
}
