package com.example.movie.service.movie.impl;

import com.example.movie.dto.movie.MovieDTO;
import com.example.movie.dto.movie.MovieTypeDTO;
import com.example.movie.model.movie.Movie;
import com.example.movie.model.movie.MovieType;
import com.example.movie.repository.movie.IMovieTypeRepository;
import com.example.movie.service.movie.IMovieTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieTypeService implements IMovieTypeService {
    @Autowired
    private IMovieTypeRepository iMovieTypeRepository;
    @Override
    public Page<MovieTypeDTO> findByName(String name, Pageable pageable) {
        Page<MovieType> movieTypeDTOPage = iMovieTypeRepository.findByNameContaining(name,pageable);
        List<MovieTypeDTO> movieTypeDTOList = new ArrayList<>();
        MovieTypeDTO movieTypeDTO;
        for(MovieType movieType : movieTypeDTOPage){
            movieTypeDTO = new MovieTypeDTO();
            Set<Movie> movieSet = movieType.getMovieSet();
            Set<MovieDTO> movieDTOSet = new HashSet<>();
            MovieDTO movieDTO;
            for (Movie movie : movieSet){
                movieDTO = new MovieDTO();
                BeanUtils.copyProperties(movie,movieDTO);
                movieDTOSet.add(movieDTO);
            }
            movieTypeDTO.setMovieSet(movieDTOSet);
            BeanUtils.copyProperties(movieType,movieTypeDTO);
            movieTypeDTOList.add(movieTypeDTO);
        }
        return new PageImpl<>(movieTypeDTOList,pageable,movieTypeDTOPage.getTotalElements());
    }

    @Override
    public MovieTypeDTO findById(int id) {
        MovieTypeDTO movieTypeDTO = new MovieTypeDTO();
        MovieType movieType = iMovieTypeRepository.findById(id);
        Set<Movie> movieSet = movieType.getMovieSet();
        Set<MovieDTO> movieDTOSet = new HashSet<>();
        MovieDTO movieDTO;
        for(Movie movie : movieSet){
            movieDTO = new MovieDTO();
            BeanUtils.copyProperties(movie,movieDTO);
            movieDTOSet.add(movieDTO);
        }
        BeanUtils.copyProperties(movieType,movieTypeDTO);
        movieTypeDTO.setMovieSet(movieDTOSet);
        return movieTypeDTO;
    }
}
