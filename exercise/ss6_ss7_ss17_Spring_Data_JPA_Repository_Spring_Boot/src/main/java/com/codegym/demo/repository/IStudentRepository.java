package com.codegym.demo.repository;

import com.codegym.demo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends PagingAndSortingRepository<Student, Integer> {

//    @Query(value = "select s from Student s where s.nameStudent like :name")
    @Query(value = "select * from student  where name_student like :name_student", nativeQuery = true)
    List<Student> findByName(@Param("name_student")String name);
}
