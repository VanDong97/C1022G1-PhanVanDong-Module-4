package com.example.movie.service.impl.employee;

import com.example.movie.model.employee.EmployeeType;
import com.example.movie.repository.employee.IEmployeeTypeRepository;
import com.example.movie.service.employee.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService implements IEmployeeTypeService {
    @Autowired
    private IEmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getAllEmployeeType() {
        return employeeTypeRepository.findAll();
    }
}
