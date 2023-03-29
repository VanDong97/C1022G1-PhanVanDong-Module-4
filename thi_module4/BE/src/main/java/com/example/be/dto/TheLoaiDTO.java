package com.example.be.dto;

import java.util.Set;

public class TheLoaiDTO {
    private Integer maTheLoai;
    private String tenTheLoai;
    private String moTaThem;
    private Set<BaiHatDTO> baiHatDTOSet;

    public Set<BaiHatDTO> getBaiHatDTOSet() {
        return baiHatDTOSet;
    }

    public void setBaiHatDTOSet(Set<BaiHatDTO> baiHatDTOSet) {
        this.baiHatDTOSet = baiHatDTOSet;
    }

    public TheLoaiDTO() {
    }

    public Integer getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(Integer maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTaThem() {
        return moTaThem;
    }

    public void setMoTaThem(String moTaThem) {
        this.moTaThem = moTaThem;
    }

    public void setBaiHatDTO(BaiHatDTO baiHatDTO) {
    }
}
