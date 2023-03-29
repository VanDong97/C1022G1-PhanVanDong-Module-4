package com.example.movie.model.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerTypeName;
    @JsonManagedReference
    @OneToMany(mappedBy = "customerType")
    Set<Customer> customerSet;

    public CustomerType(int id, String customerTypeName, Set<Customer> customerSet) {
        this.id = id;
        this.customerTypeName = customerTypeName;
        this.customerSet = customerSet;
    }

    public CustomerType() {
    }

    public CustomerType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
