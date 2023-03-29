package com.example.movie.repository.cinema;

import com.example.movie.model.cinema.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema,Integer> {
    Page<Cinema> findByNameContainingAndIsDeleted(Pageable pageable, String name, boolean isDeleted);
    Cinema findById(int id);
}
