package com.example.movie.controller;

import com.example.movie.dto.MovieTypeDTO;
import com.example.movie.service.IMovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/movie-type")
@RestController
public class MovieTypeController {
    @Autowired
    private IMovieTypeService iMovieTypeService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieTypeDTO> listMovieType(@PageableDefault(size = 5)Pageable pageable,
                                            @RequestParam(required = false,defaultValue = "")String name){
       return iMovieTypeService.findByName(name,pageable);
    }
    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public MovieTypeDTO getMovieType(@RequestParam(required = false) Integer id){
        return iMovieTypeService.findById(id);
    }
}
