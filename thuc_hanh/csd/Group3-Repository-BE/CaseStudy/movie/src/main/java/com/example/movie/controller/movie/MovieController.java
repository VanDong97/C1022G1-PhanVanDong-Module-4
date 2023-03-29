package com.example.movie.controller.movie;

import com.example.movie.dto.movie.MovieDTO;
import com.example.movie.model.movie.Movie;
import com.example.movie.model.movie.MovieType;
import com.example.movie.service.movie.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<MovieDTO> showList(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC,size = 5) Pageable pageable,
                                   @RequestParam(required = false,defaultValue = "")String name
                                   ){
        return  iMovieService.findByName(name,pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/moving")
    public Page<MovieDTO> listMoving(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC,size = 8) Pageable pageable,
                                   @RequestParam(required = false,defaultValue = "")String name
    ){
        return  iMovieService.findMoving(name,pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/up-coming")
    public Page<MovieDTO> upComingMovie(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC,size = 8) Pageable pageable,
                                     @RequestParam(required = false,defaultValue = "")String name
    ){
        return  iMovieService.upComingMovie(name,pageable);
    }
    @GetMapping("/detail")
    @ResponseStatus(HttpStatus.OK)
    public MovieDTO movieDetail(@RequestParam(required = false)Integer id){
        return iMovieService.findById(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MovieDTO movieDTO){
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO,movie);
        movie.setMovieType(new MovieType(movieDTO.getMovieTypeDTO().getId()));
        iMovieService.save(movie);
    }
    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@RequestBody MovieDTO movieDTO){
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO,movie);
        movie.setMovieType(new MovieType(movieDTO.getMovieTypeDTO().getId()));
       iMovieService.edit(movie);
    }
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false)Integer id){
        iMovieService.deleteMovie(id);
    }
}
