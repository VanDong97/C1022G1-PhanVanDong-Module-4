package com.example.movie.service.cinema.impl;

import com.example.movie.dto.cinema.BranchDTO;
import com.example.movie.dto.cinema.CinemaDTO;

import com.example.movie.model.cinema.Branch;
import com.example.movie.model.cinema.Cinema;

import com.example.movie.repository.cinema.ICinemaRepository;
import com.example.movie.service.cinema.ICinemaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService implements ICinemaService {

    @Autowired
    private ICinemaRepository cinemaRepository;
    @Override
    public Page<CinemaDTO> findByName(String name, Pageable pageable) {
        List<CinemaDTO> cinemaDTOList = new ArrayList<>();
        Page<Cinema> cinemaPage = cinemaRepository.findByNameContainingAndIsDeleted(pageable,name, false);
        CinemaDTO cinemaDTO;
        for (Cinema cinema : cinemaPage){
            cinemaDTO = new CinemaDTO();
            cinemaDTO.setBranchDTO(new BranchDTO());
            BeanUtils.copyProperties(cinema.getBranch(),cinemaDTO.getBranchDTO());
            BeanUtils.copyProperties(cinema,cinemaDTO);
            cinemaDTOList.add(cinemaDTO);
        }
        return new PageImpl<>(cinemaDTOList);
    }

    @Override
    public CinemaDTO findById(int id) {
        CinemaDTO cinemaDTO = new CinemaDTO();
        Cinema cinema = cinemaRepository.findById(id);
        cinemaDTO.setBranchDTO(new BranchDTO());
        BeanUtils.copyProperties(cinema.getBranch(),cinemaDTO.getBranchDTO());
        BeanUtils.copyProperties(cinema,cinemaDTO);
        return cinemaDTO;
    }

    @Override
    public void save(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public void delete(Integer id) {
        Cinema cinema = cinemaRepository.findById(id).get();
        cinema.setDeleted(true);
        cinema.setBranch(new Branch(cinema.getBranch().getId()));
        cinemaRepository.save(cinema);
    }

    @Override
    public void edit(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

}
