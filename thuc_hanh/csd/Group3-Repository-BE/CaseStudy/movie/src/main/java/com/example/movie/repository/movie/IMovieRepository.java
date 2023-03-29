package com.example.movie.repository.movie;

import com.example.movie.model.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "select * from movie where name like %:name% and is_delete = false",nativeQuery = true)
    Page<Movie> findByNameContaining(@Param("name") String name, Pageable pageable);
    @Query(value = "select * from movie where name like %:name% and start_day < now() and end_day > now() and is_delete = false",nativeQuery = true)
    Page<Movie> findMoving(@Param("name") String name, Pageable pageable);
    @Query(value = "select * from movie where name like %:name% and start_day > now() and is_delete = false",nativeQuery = true)
    Page<Movie> upComingMovie(@Param("name") String name, Pageable pageable);

    Movie findById(int id);
}
