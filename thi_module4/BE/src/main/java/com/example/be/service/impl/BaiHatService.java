package com.example.be.service.impl;

import com.example.be.dto.BaiHatDTO;
import com.example.be.dto.TheLoaiDTO;
import com.example.be.model.BaiHat;
import com.example.be.repository.IBaiHatRepository;
import com.example.be.service.IBaiHatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaiHatService implements IBaiHatService {

    @Autowired
    private IBaiHatRepository iBaiHatRepository;

    @Override
    public List<BaiHatDTO> findAll() {
        List<BaiHat> baiHatList = iBaiHatRepository.findAll();
        List<BaiHatDTO> baiHatDTOList = new ArrayList<>();
        BaiHatDTO baiHatDTO;
        for (BaiHat baiHat:baiHatList) {
            baiHatDTO = new BaiHatDTO();
            baiHatDTO.setTheLoaiDTO(new TheLoaiDTO());
            BeanUtils.copyProperties(baiHat.getTheLoai(),baiHatDTO.getTheLoaiDTO());
            BeanUtils.copyProperties(baiHat,baiHatDTO);
            baiHatDTOList.add(baiHatDTO);
        }
        return baiHatDTOList;
    }

    @Override
    public BaiHatDTO findById(int id) {
        BaiHatDTO baiHatDTO = new BaiHatDTO();
        BaiHat baiHat = iBaiHatRepository.findById(id).get();
        baiHatDTO.setTheLoaiDTO(new TheLoaiDTO());
        BeanUtils.copyProperties(baiHat.getTheLoai(),baiHatDTO.getTheLoaiDTO());
        BeanUtils.copyProperties(baiHat,baiHatDTO);
        return studentDTO;
    }
}
