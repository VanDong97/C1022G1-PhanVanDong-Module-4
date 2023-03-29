package com.example.movie.service.customer;

import com.example.movie.dto.customer.CustomerDTO;
import com.example.movie.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDTO> findByName(String customerName, Pageable pageable);

    CustomerDTO findById(int id);

    void save(Customer customer);

    void deleteCustomer(int id);

    void edit(Customer customer);
}
