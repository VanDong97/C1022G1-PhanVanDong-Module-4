package com.example.movie.controller.employee;

import com.example.movie.model.employee.EmployeeType;
import com.example.movie.service.employee.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-type")
@CrossOrigin("*")
public class EmployeeTypeController {
    @Autowired
    private IEmployeeTypeService employeeTypeService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeType> showEmployeeType(){
        return employeeTypeService.getAllEmployeeType();
    }
}
