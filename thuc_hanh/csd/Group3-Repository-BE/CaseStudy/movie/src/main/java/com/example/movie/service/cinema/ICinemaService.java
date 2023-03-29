package com.example.movie.service.cinema;
import com.example.movie.dto.cinema.CinemaDTO;
import com.example.movie.model.cinema.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICinemaService {


    Page<CinemaDTO> findByName(String name, Pageable pageable);
    CinemaDTO findById(int id);
    void save(Cinema cinema);

    void delete(Integer id);

    void edit(Cinema cinema);
}
