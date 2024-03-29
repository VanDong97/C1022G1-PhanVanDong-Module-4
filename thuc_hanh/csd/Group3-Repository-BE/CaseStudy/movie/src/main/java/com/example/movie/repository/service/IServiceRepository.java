package com.example.movie.repository.service;

import com.example.movie.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service,Integer> {

    Page<Service> findByNameContainingAndIsDeleteFalse(String name, Pageable pageable);

    Service findById(int id);
}
