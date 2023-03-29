package com.example.movie.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "employeeType")
    @JsonBackReference
    private Set<Employee> employeeSet;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    public EmployeeType(int id) {
    }

    public EmployeeType() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
