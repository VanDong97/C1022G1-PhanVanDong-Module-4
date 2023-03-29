package com.example.be.service.impl;

import com.example.be.dto.BaiHatDTO;
import com.example.be.dto.TheLoaiDTO;
import com.example.be.model.BaiHat;
import com.example.be.model.TheLoai;
import com.example.be.repository.ITheLoaiRepository;
import com.example.be.service.ITheLoaiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TheLoaiService implements ITheLoaiService {

    @Autowired
    private ITheLoaiRepository iTheLoaiRepository;

    @Override
    public TheLoaiDTO findById(int id) {
        TheLoaiDTO theLoaiDTO = new TheLoaiDTO();
        TheLoai theLoai = iTheLoaiRepository.findById(id).get();
        theLoaiDTO.setBaiHatDTO(new BaiHatDTO());
//        BeanUtils.copyProperties(theLoai.getBaiHatSet(),theLoaiDTO.getBaiHatDTOSet());
        BeanUtils.copyProperties(theLoai,theLoaiDTO);
        return theLoaiDTO;
    }

    @Override
    public List<TheLoaiDTO> findAll() {
        List<TheLoai> theLoaiList = iTheLoaiRepository.findAll();
        List<TheLoaiDTO> theLoaiDTOList = new ArrayList<>();
        TheLoaiDTO theLoaiDTO;
        for (TheLoai theLoai : theLoaiList) {
            theLoaiDTO = new TheLoaiDTO();
            theLoaiDTO.setBaiHatDTO(new BaiHatDTO());
//            BeanUtils.copyProperties(theLoai.getBaiHatSet(), theLoaiDTO.getBaiHatDTOSet());
            BeanUtils.copyProperties(theLoai, theLoaiDTO);
            theLoaiDTOList.add(theLoaiDTO);
        }
        return theLoaiDTOList;
    }
}

