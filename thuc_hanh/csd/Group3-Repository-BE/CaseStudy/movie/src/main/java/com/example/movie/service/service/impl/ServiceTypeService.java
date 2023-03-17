package com.example.movie.service.service.impl;

import com.example.movie.dto.service.ServiceDTO;
import com.example.movie.dto.service.ServiceTypeDTO;
import com.example.movie.model.service.ServiceType;
import com.example.movie.repository.service.IServiceTypeRepository;
import com.example.movie.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public Page<ServiceTypeDTO> finByName(String name, Pageable pageable) {
        Page<ServiceType> serviceTypeDTOPage = iServiceTypeRepository.findByNameContaining(name, pageable);
        List<ServiceTypeDTO> serviceTypeDTOList = new ArrayList<>();
        ServiceTypeDTO serviceTypeDTO;
        for (ServiceType serviceType : serviceTypeDTOPage){
            serviceTypeDTO = new ServiceTypeDTO();
            Set<com.example.movie.model.service.Service> serviceSet = serviceType.getServiceSet();
            Set<ServiceDTO> serviceDTOSet = new HashSet<>();
            ServiceDTO serviceDTO;
            for (com.example.movie.model.service.Service service : serviceSet){
                serviceDTO = new ServiceDTO();
                BeanUtils.copyProperties(service,serviceDTO);
                serviceDTOSet.add(serviceDTO);
            }
            serviceTypeDTO.setServiceDTOSet(serviceDTOSet);
            BeanUtils.copyProperties(serviceType,serviceTypeDTO);
            serviceTypeDTOList.add(serviceTypeDTO);
        }
        return new PageImpl<>(serviceTypeDTOList);
    }

    @Override
    public ServiceTypeDTO findById(int id) {
        ServiceTypeDTO serviceTypeDTO = new ServiceTypeDTO();
        ServiceType serviceType = iServiceTypeRepository.findById(id);
        Set<com.example.movie.model.service.Service> serviceSet = serviceType.getServiceSet();
        Set<ServiceDTO> serviceDTOSet = new HashSet<>();
        ServiceDTO serviceDTO;
        for (com.example.movie.model.service.Service service : serviceSet){
            serviceDTO = new ServiceDTO();
            BeanUtils.copyProperties(service,serviceDTO);
            serviceDTOSet.add(serviceDTO);
        }
        BeanUtils.copyProperties(serviceType,serviceTypeDTO);
        serviceTypeDTO.setServiceDTOSet(serviceDTOSet);
        return serviceTypeDTO;
    }

}
