package com.example.movie.service.service;

import com.example.movie.dto.service.ServiceDTO;
import com.example.movie.dto.service.ServiceTypeDTO;
import com.example.movie.model.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {

    Page<ServiceDTO> findByName(String name, Pageable pageable);
    ServiceDTO findById(int id);
    void save(Service service);
    void delete(int id);
}
