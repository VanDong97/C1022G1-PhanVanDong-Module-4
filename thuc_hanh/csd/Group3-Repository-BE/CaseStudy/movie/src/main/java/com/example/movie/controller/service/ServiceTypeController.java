package com.example.movie.controller.service;

import com.example.movie.dto.service.ServiceTypeDTO;
import com.example.movie.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/service-type")
@CrossOrigin("*")
@RestController
public class ServiceTypeController {

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<ServiceTypeDTO> listServiceType(@PageableDefault(size = 4)Pageable pageable,
                                                @RequestParam(required = false, defaultValue = "") String name){
        return iServiceTypeService.finByName(name, pageable);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public ServiceTypeDTO getServiceType(@RequestParam(required = false)Integer id){
        return iServiceTypeService.findById(id);
    }
}
