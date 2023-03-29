package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theloaith")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTheLoai;
    private String tenTheLoai;
    private String moTaThem;

    @OneToMany(mappedBy = "theloai",cascade = CascadeType.ALL)
    private Set<BaiHat> baiHatSet;

    public TheLoai() {
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

    public Set<BaiHat> getBaiHatSet() {
        return baiHatSet;
    }

    public void setBaiHatSet(Set<BaiHat> baiHatSet) {
        this.baiHatSet = baiHatSet;
    }
}
