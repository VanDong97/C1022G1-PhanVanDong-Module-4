package com.example.movie.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String gender;
    private String age;
    private String phoneNumber;
    private String address;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @JoinColumn(name = "is_deleted")
    private Boolean isDelete =false;

    public Customer(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }

    public Customer() {
    }

    public Customer(int id, String customerName, String gender, String age, String phoneNumber, String address, CustomerType customerType) {
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
