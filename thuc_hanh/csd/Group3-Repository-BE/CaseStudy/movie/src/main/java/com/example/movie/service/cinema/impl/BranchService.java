package com.example.movie.service.cinema.impl;

import com.example.movie.dto.cinema.BranchDTO;
import com.example.movie.dto.cinema.CinemaDTO;

import com.example.movie.model.cinema.Branch;
import com.example.movie.model.cinema.Cinema;
import com.example.movie.repository.cinema.IBranchRepository;
import com.example.movie.service.cinema.IBranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BranchService implements IBranchService {

    @Autowired
    private IBranchRepository branchRepository;


    @Override
    public Page<BranchDTO> findByName(String name, Pageable pageable) {
        Page<Branch> branchPage = branchRepository.findByBranchNameContaining(name,pageable);
        List<BranchDTO> branchDTOList = new ArrayList<>();
        BranchDTO branchDTO;
        for(Branch branch : branchPage){
            branchDTO = new BranchDTO();
            Set<Cinema> cinemaSet = branch.getCinemaSet();
            Set<CinemaDTO> cinemaDTOSet = new HashSet<>();
            CinemaDTO cinemaDTO;
            for (Cinema cinema : cinemaSet){
                cinemaDTO = new CinemaDTO();
                BeanUtils.copyProperties(cinema,cinemaDTO);
                cinemaDTOSet.add(cinemaDTO);
            }
            branchDTO.setCinemaSet(cinemaDTOSet);
            BeanUtils.copyProperties(branch,branchDTO);
            branchDTOList.add(branchDTO);
        }
        return new PageImpl<>(branchDTOList);
    }

    @Override
    public BranchDTO findById(int id) {
        BranchDTO branchDTO = new BranchDTO();
        Branch branch = branchRepository.findById(id);
        Set<Cinema> cinemaSet = branch.getCinemaSet();
        Set<CinemaDTO> cinemaDTOSet = new HashSet<>();
        CinemaDTO cinemaDTO;
        for (Cinema cinema: cinemaSet){
            cinemaDTO = new CinemaDTO();
            BeanUtils.copyProperties(cinema,cinemaDTO);
            cinemaDTOSet.add(cinemaDTO);
        }
        BeanUtils.copyProperties(branch,branchDTO);
        branchDTO.setCinemaSet(cinemaDTOSet);
        return branchDTO;


    }
}
