package com.example.movie.dto.service;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;

public class ServiceDTO {
    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private String price;
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
}
