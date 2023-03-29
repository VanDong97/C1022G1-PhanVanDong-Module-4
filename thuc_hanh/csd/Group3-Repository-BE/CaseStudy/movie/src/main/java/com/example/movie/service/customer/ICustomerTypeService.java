package com.example.movie.service.customer;

import com.example.movie.dto.customer.CustomerTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerTypeService {
    Page<CustomerTypeDTO> findByName(String customerTypeName, Pageable pageable);

    CustomerTypeDTO findById(int id);
}
