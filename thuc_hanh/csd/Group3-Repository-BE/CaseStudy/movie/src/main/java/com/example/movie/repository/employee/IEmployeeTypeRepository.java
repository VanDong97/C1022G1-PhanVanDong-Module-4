package com.example.movie.repository.employee;

import com.example.movie.model.employee.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
}
