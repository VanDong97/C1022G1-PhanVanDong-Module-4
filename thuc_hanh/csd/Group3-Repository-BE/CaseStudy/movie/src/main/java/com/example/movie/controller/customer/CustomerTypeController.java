package com.example.movie.controller.customer;

import com.example.movie.dto.customer.CustomerTypeDTO;
import com.example.movie.dto.movie.MovieTypeDTO;
import com.example.movie.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerTypeDTO> listCustomerType(@PageableDefault(size = 4) Pageable pageable,
                                                  @RequestParam(required = false, defaultValue = "") String name) {
        return customerTypeService.findByName(name, pageable);
    }
}
