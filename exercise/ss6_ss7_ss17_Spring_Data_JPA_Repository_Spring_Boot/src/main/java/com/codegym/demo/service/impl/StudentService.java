package com.codegym.demo.service.impl;

import com.codegym.demo.model.Student;
import com.codegym.demo.repository.IStudentRepository;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return (List<Student>) iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return iStudentRepository.findById(id).get();
    }
}
