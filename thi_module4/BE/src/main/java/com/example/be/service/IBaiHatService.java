package com.example.be.service;

import com.example.be.dto.BaiHatDTO;

import java.util.List;

public interface IBaiHatService {

    List<BaiHatDTO> findAll();

    BaiHatDTO findById(int id);
}
