package com.example.movie.service.impl;

import com.example.movie.dto.MovieDTO;
import com.example.movie.dto.MovieTypeDTO;
import com.example.movie.model.Movie;
import com.example.movie.repository.IMovieRepository;
import com.example.movie.service.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository iMovieRepository;

    @Override
    public Page<MovieDTO> findByName(String name, Pageable pageable) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        Page<Movie> moviePage = iMovieRepository.findByNameContaining(name,pageable);
        MovieDTO movieDTO;
        for (Movie movie : moviePage){
            movieDTO = new MovieDTO();
            movieDTO.setMovieTypeDTO(new MovieTypeDTO());
            BeanUtils.copyProperties(movie.getMovieType(),movieDTO.getMovieTypeDTO());
            BeanUtils.copyProperties(movie,movieDTO);
            movieDTOList.add(movieDTO);
        }
        return new PageImpl<>(movieDTOList);
    }

    @Override
    public MovieDTO findById(int id) {
        MovieDTO movieDTO = new MovieDTO();
        Movie movie = iMovieRepository.findById(id);
        movieDTO.setMovieTypeDTO(new MovieTypeDTO());
        BeanUtils.copyProperties(movie.getMovieType(),movieDTO.getMovieTypeDTO());
        BeanUtils.copyProperties(movie,movieDTO);
        return movieDTO;
    }

    @Override
    public void save(Movie movie) {
        iMovieRepository.save(movie);
    }
}
