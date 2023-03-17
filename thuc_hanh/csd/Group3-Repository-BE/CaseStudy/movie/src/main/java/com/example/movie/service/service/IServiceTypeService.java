package com.example.movie.service.service;

import com.example.movie.dto.service.ServiceTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceTypeService {
    Page<ServiceTypeDTO> finByName(String name, Pageable pageable);
    ServiceTypeDTO findById(int id);
}
