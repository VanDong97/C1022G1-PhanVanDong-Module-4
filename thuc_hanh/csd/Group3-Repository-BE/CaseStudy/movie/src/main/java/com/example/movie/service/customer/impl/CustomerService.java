package com.example.movie.service.customer.impl;

import com.example.movie.dto.customer.CustomerDTO;
import com.example.movie.dto.customer.CustomerTypeDTO;
import com.example.movie.model.customer.Customer;
import com.example.movie.model.customer.CustomerType;
import com.example.movie.repository.customer.ICustomerRepository;
import com.example.movie.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<CustomerDTO> findByName(String customerName, Pageable pageable) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        Page<Customer> customerPage = customerRepository.findByCustomerNameContainingAndIsDeleteFalse(customerName, pageable);
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return new PageImpl<>(customerDTOList);
    }

    @Override
    public CustomerDTO findById(int id) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerRepository.findById(id);
        customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
        BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id);
        customer.setIsDelete(true);
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }
}
