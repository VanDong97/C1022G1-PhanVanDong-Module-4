package com.example.movie.controller.customer;

import com.example.movie.dto.customer.CustomerDTO;
import com.example.movie.dto.movie.MovieDTO;
import com.example.movie.model.customer.Customer;
import com.example.movie.model.customer.CustomerType;
import com.example.movie.model.movie.Movie;
import com.example.movie.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<CustomerDTO> showList(@RequestParam(required = false, defaultValue = "") String customerName,
                                      @PageableDefault(size = 4) Pageable pageable) {
        return customerService.findByName(customerName, pageable);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerType(new CustomerType(customerDTO.getCustomerTypeDTO().getId()));
        BeanUtils.copyProperties(customerDTO.getCustomerTypeDTO(), customer.getCustomerType());
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.save(customer);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false) Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setCustomerType(new CustomerType(customerDTO.getCustomerTypeDTO().getId()));
        customerService.edit(customer);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getService(@RequestParam(required = false) Integer id) {
        return customerService.findById(id);
    }
}
