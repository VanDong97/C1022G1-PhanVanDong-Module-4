package com.example.movie.controller;

import com.example.movie.dto.MovieDTO;
import com.example.movie.model.Movie;
import com.example.movie.service.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.certpath.OCSPResponse;

import java.util.List;
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<MovieDTO> showList(@RequestParam(required = false,defaultValue = "")String name,
                                   @PageableDefault(size = 5) Pageable pageable){
        return  iMovieService.findByName(name,pageable);
    }
    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO showList(@RequestParam(required = false)Integer id){
        return iMovieService.findById(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MovieDTO movieDTO){
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO,movie);
        iMovieService.save(movie);
    }
}
