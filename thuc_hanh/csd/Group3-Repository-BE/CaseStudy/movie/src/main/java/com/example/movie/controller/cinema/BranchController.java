package com.example.movie.controller.cinema;

import com.example.movie.dto.cinema.BranchDTO;
import com.example.movie.service.cinema.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/branch-type")
@CrossOrigin("*")
public class BranchController {
    @Autowired
    private IBranchService branchService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BranchDTO> listBranch(@PageableDefault(size = 5)Pageable pageable,
                                            @RequestParam(required = false,defaultValue = "")String name){
        return branchService.findByName(name,pageable);
    }

    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public BranchDTO getBranch(@RequestParam(required = false) Integer id){
        return branchService.findById(id);
    }
}
