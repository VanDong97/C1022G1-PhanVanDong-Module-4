package com.example.movie.service.cinema;

import com.example.movie.dto.cinema.BranchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBranchService {
   Page<BranchDTO> findByName(String name, Pageable pageable);
   BranchDTO findById(int id);

}
