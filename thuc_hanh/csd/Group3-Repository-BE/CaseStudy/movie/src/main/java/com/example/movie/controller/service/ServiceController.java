package com.example.movie.controller.service;

import com.example.movie.dto.service.ServiceDTO;
import com.example.movie.dto.service.ServiceTypeDTO;
import com.example.movie.model.service.Service;
import com.example.movie.model.service.ServiceType;
import com.example.movie.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService iServiceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<ServiceDTO> showList(@RequestParam(required = false,defaultValue = "") String name,
                                     @PageableDefault(size = 4)Pageable pageable){
        return iServiceService.findByName(name,pageable);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public ServiceDTO getService(@RequestParam(required = false)Integer id){
        return iServiceService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ServiceDTO serviceDTO){
        Service service = new Service();
        BeanUtils.copyProperties(serviceDTO,service);
        service.setServiceType(new ServiceType(serviceDTO.getServiceTypeDTO().getId()));
        iServiceService.save(service);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false) Integer id){
        iServiceService.delete(id);
    }
}
