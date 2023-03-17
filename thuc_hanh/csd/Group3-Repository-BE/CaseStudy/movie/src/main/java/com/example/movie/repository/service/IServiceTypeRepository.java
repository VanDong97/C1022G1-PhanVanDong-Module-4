package com.example.movie.repository.service;

import com.example.movie.model.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {

    Page<ServiceType> findByNameContaining(String name, Pageable pageable);

    ServiceType findById (int id);
}
