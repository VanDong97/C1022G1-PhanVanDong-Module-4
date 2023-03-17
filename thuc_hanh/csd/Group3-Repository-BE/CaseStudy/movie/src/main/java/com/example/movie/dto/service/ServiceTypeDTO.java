package com.example.movie.dto.service;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class ServiceTypeDTO {
    private Integer id;
    private String name;
    Set<ServiceDTO> serviceDTOSet;

    public ServiceTypeDTO() {
    }

    public ServiceTypeDTO(Integer id, String name, Set<ServiceDTO> serviceDTOSet) {
        this.id = id;
        this.name = name;
        this.serviceDTOSet = serviceDTOSet;
    }

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

    public Set<ServiceDTO> getServiceDTOSet() {
        return serviceDTOSet;
    }

    public void setServiceDTOSet(Set<ServiceDTO> serviceDTOSet) {
        this.serviceDTOSet = serviceDTOSet;
    }
}
