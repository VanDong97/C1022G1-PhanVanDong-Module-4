package com.example.be.controller;

import com.example.be.dto.BaiHatDTO;
import com.example.be.service.IBaiHatService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/baihat")
@CrossOrigin("*")
public class BaiHatController {
    private IBaiHatService iBaiHatService;

    @GetMapping("")
    public List<BaiHatDTO> getBaiHat(){
        return iBaiHatService.findAll();
    }

    @GetMapping("/detail/{maTheLoai}")
    @ResponseStatus(HttpStatus.OK)
    public BaiHatDTO getStudentDetail(@PathVariable int id) {
        return iBaiHatService.findById(id);
    }
}
