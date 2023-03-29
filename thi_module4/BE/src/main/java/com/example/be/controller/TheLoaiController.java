package com.example.be.controller;

import com.example.be.dto.TheLoaiDTO;
import com.example.be.service.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/theloai")
@CrossOrigin("*")
public class TheLoaiController {

    @Autowired
    private ITheLoaiService iTheLoaiService;


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TheLoaiDTO> getClazzes() {
        return iTheLoaiService.findAll();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public TheLoaiDTO getClazz(@PathVariable int id) {
        return iTheLoaiService.findById(id);
    }
}
