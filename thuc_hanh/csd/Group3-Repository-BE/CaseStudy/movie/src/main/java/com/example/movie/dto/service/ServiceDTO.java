package com.example.movie.dto.service;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.validation.annotation.Validated;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Annotation;

public class ServiceDTO implements Validated {
    private Integer id;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "không được để trống")
    private String name;

    private String startDate;

    private String endDate;

    @Min(value = 0, message = "Giá bán phải lớn hơn 0")
    private String price;

    @NotBlank(message = "Không được để trống")
    private String img;

    private ServiceTypeDTO serviceTypeDTO;

    public ServiceDTO() {
    }

    public ServiceDTO(Integer id, String name, String startDate, String endDate, String price, ServiceTypeDTO serviceTypeDTO) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.serviceTypeDTO = serviceTypeDTO;
    }

    public ServiceDTO(Integer id) {
        this.id = id;
    }
    @JoinColumn(name = "is_delete")
    private Boolean isDelete = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ServiceTypeDTO getServiceTypeDTO() {
        return serviceTypeDTO;
    }

    public void setServiceTypeDTO(ServiceTypeDTO serviceTypeDTO) {
        this.serviceTypeDTO = serviceTypeDTO;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public Class<?>[] value() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
