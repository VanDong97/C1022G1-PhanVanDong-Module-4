package com.example.movie.repository.cinema;

import com.example.movie.model.cinema.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer> {
    Page<Branch> findByBranchNameContaining(String name, Pageable pageable);
    Branch findById(int id);
}
