package com.example.movie.controller.movie;

import com.example.movie.dto.movie.MovieTypeDTO;
import com.example.movie.service.movie.IMovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/movie-type")
@RestController
@CrossOrigin("*")
public class MovieTypeController {
    @Autowired
    private IMovieTypeService iMovieTypeService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<MovieTypeDTO> listMovieType(@PageableDefault(size = 10)Pageable pageable,
                                            @RequestParam(required = false,defaultValue = "")String name){
       return iMovieTypeService.findByName(name,pageable);
    }
    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public MovieTypeDTO getMovieType(@RequestParam(required = false) Integer id){
        return iMovieTypeService.findById(id);
    }
}
