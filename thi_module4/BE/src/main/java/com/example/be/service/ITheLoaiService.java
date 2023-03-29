package com.example.be.service;

import com.example.be.dto.TheLoaiDTO;

import java.util.List;

public interface ITheLoaiService {
    TheLoaiDTO findById(int id);

    List<TheLoaiDTO> findAll();
}
