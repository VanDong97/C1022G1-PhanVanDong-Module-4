package com.example.movie.dto;

import com.example.movie.model.employee.EmployeeType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeDTO implements Validator {
    private int id;
    private EmployeeType employeeType;
    @NotBlank(message = "Tên không được để trống!")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Tên sai định dạng! (không được có số và kí tự đặc biệt)")
    private String name;
    private String gender;
    private String idCard;
    private String dateOfBirth;
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "SĐT phải đúng với định dạng (+84)xxxxxxxxx")
    private String phoneNumber;
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String address;
    private String salary;

    public EmployeeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTO employeeDTO = (EmployeeDTO) target;

        //Validate DateOfBirth
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(employeeDTO.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh phải đúng định dạng (dd/MM/YYYY)");
        }

        //Validate name
        String strRegex = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if (!employeeDTO.getName().matches(strRegex)) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa ký tự đặc biệt và chứa số");
        }
    }
}
