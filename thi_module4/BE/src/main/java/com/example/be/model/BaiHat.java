package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "baihat")
public class BaiHat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maBaiHat;
    private String tenBaiHat;
    private String tenTacGia;
    private String ngayPhatHanh;
    private String moTaThem;

    @ManyToOne
    @JoinColumn(name = "theLoai_maTheLoai",nullable = false,referencedColumnName = "maTheLoai")
    @JsonManagedReference
    private TheLoai theLoai;

    public BaiHat() {
    }

    public Integer getMaBaiHat() {
        return maBaiHat;
    }

    public void setMaBaiHat(Integer maBaiHat) {
        this.maBaiHat = maBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getMoTaThem() {
        return moTaThem;
    }

    public void setMoTaThem(String moTaThem) {
        this.moTaThem = moTaThem;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }
}
