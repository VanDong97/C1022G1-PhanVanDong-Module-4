package com.example.movie.service.employee;

import com.example.movie.dto.EmployeeDTO;
import com.example.movie.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> searchEmployee(String name, String idCard, int EmployeeTypeId, Pageable pageable);

    Page<Employee> searchEmployee(String name, String idCard, Pageable pageable);

    boolean addNewEmployee(Employee employee);

    boolean editEmployee(Employee employee);

    Employee findById(int id);

    void getDeleteEmployee(int id);

    List<Employee> getAllEmployee();

}
