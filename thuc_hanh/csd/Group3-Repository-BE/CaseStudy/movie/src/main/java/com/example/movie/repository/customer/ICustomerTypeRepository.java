package com.example.movie.repository.customer;

import com.example.movie.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    Page<CustomerType> findByCustomerTypeNameContaining(String name,Pageable pageable);

    CustomerType findById(int id);

}
