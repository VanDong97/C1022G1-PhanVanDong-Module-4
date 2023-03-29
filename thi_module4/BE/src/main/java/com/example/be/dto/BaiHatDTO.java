package com.example.be.dto;

public class BaiHatDTO {
    private Integer maBaiHat;
    private String tenBaiHat;
    private String tenTacGia;
    private String ngayPhatHanh;
    private String moTaThem;
    private TheLoaiDTO theLoaiDTO;

    public BaiHatDTO() {
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
    public TheLoaiDTO getTheLoaiDTO() {
        return theLoaiDTO;
    }

    public void setTheLoaiDTO(TheLoaiDTO theLoaiDTO) {
        this.theLoaiDTO = theLoaiDTO;
    }
}
