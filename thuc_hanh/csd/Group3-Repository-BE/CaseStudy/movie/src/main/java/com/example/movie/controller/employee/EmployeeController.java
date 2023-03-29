package com.example.movie.controller.employee;

import com.example.movie.dto.EmployeeDTO;
import com.example.movie.model.employee.Employee;
import com.example.movie.model.employee.EmployeeType;
import com.example.movie.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/show-list")
    public ResponseEntity<Page<Employee>> showEmployee(@RequestParam(required = false, defaultValue = "", name = "searchName") String name,
                                                       @RequestParam(required = false, defaultValue = "", name = "searchIdCard") String idCard,
                                                       @RequestParam(required = false, defaultValue = "-1", name = "searchEmployeeType") int employeeTypeId,
                                                       @PageableDefault(size = 5) Pageable pageable) {
        Page<Employee> employeeList;
        if (employeeTypeId == -1) {
            employeeList = employeeService.searchEmployee(name, idCard, pageable);
        } else {
            employeeList = employeeService.searchEmployee(name, idCard, employeeTypeId, pageable);
        }
        if (employeeList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeType(new EmployeeType(employeeDTO.getEmployeeType().getId()));
        BeanUtils.copyProperties(employeeDTO.getEmployeeType(),employee.getEmployeeType());
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeService.addNewEmployee(employee);}

    @PutMapping(value = "/{id}")
    public ResponseEntity<Page<Employee>> editEmployee(@RequestBody Employee employee) {
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false) Integer id) {
        employeeService.getDeleteEmployee(id);
    }
}
