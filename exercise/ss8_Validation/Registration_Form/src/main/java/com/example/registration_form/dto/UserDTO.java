package com.example.registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserDTO implements Validator {

    @NotNull
    @NotBlank(message = "{firstName.notBlank}")
    @Column(name = "firstName",nullable = false)
    @Size(min = 5,max = 45)
    private String firstName;

    @NotNull
    @NotBlank(message = "{lastName.notBlank}")
    @Column(name = "lastName",nullable = false)
    @Size(min = 5,max = 45)
    private String lastName;

    @NotNull
    @NotBlank(message = "{phoneNumber.notBlank}")
    @Pattern(regexp = "\"^(090|091|\\\\(84\\\\)\\\\+90|\\\\(84\\\\)\\\\+91)[\\\\d]{7}$\"")
    private String phoneNumber;

    @NotNull
    @NotBlank(message = "{age.notBlank}")
    @Min(value = 18)
    private String age;

    @NotNull
    @NotBlank(message = "{email.notBlank}")
    @Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
