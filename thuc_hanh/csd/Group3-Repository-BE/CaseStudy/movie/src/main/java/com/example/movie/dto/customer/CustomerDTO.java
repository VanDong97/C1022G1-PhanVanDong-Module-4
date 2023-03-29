package com.example.movie.dto.customer;

public class CustomerDTO {
    private int id;
    private String customerName;
    private String gender;
    private String age;
    private String phoneNumber;
    private String address;
    private CustomerTypeDTO customerTypeDTO;
    private Boolean isDeleted = false;

    public CustomerDTO(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String customerName, String gender, String age, String phoneNumber, String address, CustomerTypeDTO customerTypeDTO) {
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerTypeDTO = customerTypeDTO;
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

    public CustomerTypeDTO getCustomerTypeDTO() {
        return customerTypeDTO;
    }

    public void setCustomerTypeDTO(CustomerTypeDTO customerTypeDTO) {
        this.customerTypeDTO = customerTypeDTO;
    }
}
