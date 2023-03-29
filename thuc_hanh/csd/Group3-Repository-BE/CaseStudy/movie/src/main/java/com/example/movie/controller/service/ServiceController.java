package com.example.movie.controller.service;

import com.example.movie.dto.service.ServiceDTO;
import com.example.movie.model.service.Service;
import com.example.movie.model.service.ServiceType;
import com.example.movie.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
@CrossOrigin("*")
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<ServiceDTO> showList(@RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "0") String pageNumber,
                                     @PageableDefault(size = 4) Pageable pageable) {
        Pageable newPageable = PageRequest.of(Integer.parseInt(pageNumber) > 1 ?
                Integer.parseInt(pageNumber) - 1 : 0, pageable.getPageSize(), pageable.getSort());
        return iServiceService.findByName(name, newPageable);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public ServiceDTO getService(@RequestParam(required = false) Integer id) {
        return iServiceService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, String>> create(@Validated @RequestBody ServiceDTO serviceDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDTO, service);
            service.setServiceType(new ServiceType(serviceDTO.getServiceTypeDTO().getId()));
            iServiceService.save(service);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false) Integer id) {
        iServiceService.delete(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, String>> edit(@Validated @RequestBody ServiceDTO serviceDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDTO, service);
            service.setServiceType(new ServiceType(serviceDTO.getServiceTypeDTO().getId()));
            iServiceService.edit(service);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
