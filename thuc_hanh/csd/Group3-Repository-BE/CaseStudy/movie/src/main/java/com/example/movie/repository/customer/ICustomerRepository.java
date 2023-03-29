package com.example.movie.repository.customer;

import com.example.movie.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByCustomerNameContainingAndIsDeleteFalse(String customerName, Pageable pageable);

    Customer findById(int id);
}
