package com.example.player.dto;

import com.example.player.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class PLayerSoccerDTO implements Validator {
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5,max = 100,message = "Độ dài từ 4 đến 100 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\\\-]+$",message = "Tên Không chứa kí tự đặc biệt")
    private String name;

    @NotNull(message = "Không được để trống")
    @Size(min = 15,max = 100,message = "Tuổi phải từ 16 đến 100")
    private String dateOfBirth;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]+$", message = "Kinh nghiệm phải là số nguyên dương")
    private String experience;

    @Pattern(regexp = "Tiền Đạo|Tiền Vệ|Trung Vệ|Hậu Vệ|Thủ Môn",message = "Vị trị là phải 1 trong 4 vị trí trên (Tiền Đạo,Tiền Vệ,Trung Vệ,Hậu Vệ,Thủ Môn)")
    private String location;
    @NotNull(message = "Không được để trống")
    private String img;

    private Team team;

    public PLayerSoccerDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
