package com.example.movie.repository.employee;

import com.example.movie.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM Employee where name like concat('%',:name,'%') and id_card like concat('%',:idCard,'%') and employee_type_id = :employeeTypeId and is_deleted = false", nativeQuery = true)
    Page<Employee> searchEmployee(@Param("name") String name, @Param("idCard") String idCard, @Param("employeeTypeId") int employeeTypeId, Pageable pageable);

    @Query(value = "SELECT * FROM Employee where name like concat('%',:name,'%') and id_card like concat('%',:idCard,'%') and is_deleted = false", nativeQuery = true)
    Page<Employee> searchEmployee(@Param("name") String name, @Param("idCard") String idCard, Pageable pageable);

    Employee findByIdCard(String idCard);
}
