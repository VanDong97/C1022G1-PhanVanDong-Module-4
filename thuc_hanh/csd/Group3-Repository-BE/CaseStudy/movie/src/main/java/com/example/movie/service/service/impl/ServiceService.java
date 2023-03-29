package com.example.movie.service.service.impl;

import com.example.movie.dto.service.ServiceDTO;
import com.example.movie.dto.service.ServiceTypeDTO;
import com.example.movie.model.service.Service;
import com.example.movie.model.service.ServiceType;
import com.example.movie.repository.service.IServiceRepository;
import com.example.movie.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<ServiceDTO> findByName(String name, Pageable pageable) {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        Page<Service> servicePage = iServiceRepository.findByNameContainingAndIsDeleteFalse(name, pageable);
        ServiceDTO serviceDTO;
        for (Service service : servicePage.getContent()) {
            serviceDTO = new ServiceDTO();
            serviceDTO.setServiceTypeDTO(new ServiceTypeDTO());
            BeanUtils.copyProperties(service.getServiceType(), serviceDTO.getServiceTypeDTO());
            BeanUtils.copyProperties(service, serviceDTO);
            serviceDTOList.add(serviceDTO);
        }
        return new PageImpl<>(serviceDTOList, servicePage.getPageable(), servicePage.getTotalElements());
    }

    @Override
    public ServiceDTO findById(int id) {
        ServiceDTO serviceDTO = new ServiceDTO();
        Service service = iServiceRepository.findById(id);
        serviceDTO.setServiceTypeDTO(new ServiceTypeDTO());
        BeanUtils.copyProperties(service.getServiceType(),serviceDTO.getServiceTypeDTO());
        BeanUtils.copyProperties(service,serviceDTO);
        return serviceDTO;
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void delete(int id) {
        Service service = iServiceRepository.findById(id);
        service.setDelete(true);
        service.setServiceType(new ServiceType(service.getServiceType().getId()));
        iServiceRepository.save(service);
    }

    @Override
    public void edit(Service service) {
        iServiceRepository.save(service);
    }
}
