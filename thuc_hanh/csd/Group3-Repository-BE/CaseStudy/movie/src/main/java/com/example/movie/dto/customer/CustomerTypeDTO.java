package com.example.movie.dto.customer;

import com.example.movie.dto.customer.CustomerDTO;

import java.util.Set;

public class  CustomerTypeDTO {
    private int id;
    private String customerTypeName;
    Set<CustomerDTO> customerSet;

    public CustomerTypeDTO() {
    }

    public CustomerTypeDTO(int id, String customerTypeName, Set<CustomerDTO> customerSet) {
        this.id = id;
        this.customerTypeName = customerTypeName;
        this.customerSet = customerSet;
    }

    public CustomerTypeDTO(int id) {
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

    public Set<CustomerDTO> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<CustomerDTO> customerSet) {
        this.customerSet = customerSet;
    }
}
