package com.example.movie.controller.cinema;


import com.example.movie.dto.cinema.CinemaDTO;
import com.example.movie.model.cinema.Branch;
import com.example.movie.model.cinema.Cinema;
import com.example.movie.service.cinema.ICinemaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cinema")
@CrossOrigin("*")
public class CinemaController {

    @Autowired
    private ICinemaService cinemaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<CinemaDTO> showList(@RequestParam(required = false, defaultValue = "") String name,
                                    @PageableDefault(size = 20) Pageable pageable) {
        return cinemaService.findByName(name, pageable);
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CinemaDTO getCinema(@PathVariable(required = false) Integer id) {
        return cinemaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody CinemaDTO cinemaDTO) {
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaDTO, cinema);
        cinema.setBranch(new Branch(cinemaDTO.getBranchDTO().getId()));
        cinemaService.save(cinema);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false) Integer id){
        cinemaService.delete(id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@RequestBody CinemaDTO cinemaDTO){
        Cinema cinema = new Cinema();
        BeanUtils.copyProperties(cinemaDTO, cinema);
        cinema.setBranch(new Branch(cinemaDTO.getBranchDTO().getId()));
        cinemaService.edit(cinema);
    }
}
