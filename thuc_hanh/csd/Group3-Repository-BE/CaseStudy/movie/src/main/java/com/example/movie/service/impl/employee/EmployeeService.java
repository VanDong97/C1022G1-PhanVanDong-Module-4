package com.example.movie.service.impl.employee;

import com.example.movie.dto.EmployeeDTO;
import com.example.movie.model.employee.Employee;
import com.example.movie.repository.employee.IEmployeeRepository;
import com.example.movie.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> searchEmployee(String name, String phoneNumber, int EmployeeTypeId, Pageable pageable) {
        return employeeRepository.searchEmployee(name, phoneNumber, EmployeeTypeId, pageable);
    }

    @Override
    public Page<Employee> searchEmployee(String name, String phoneNumber, Pageable pageable) {
        return employeeRepository.searchEmployee(name, phoneNumber, pageable);
    }

    @Override
    public boolean addNewEmployee(Employee employee) {
//        if (employeeRepository.findByIdCard(employee.getIdCard()) == null) {
//            return false;
//        }
//        try {
            employeeRepository.save(employee);
//        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
//            return false;
//        }
        return true;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
            return false;
        }
        try {
            employeeRepository.save(employee);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void getDeleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setDeleted(true);
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
