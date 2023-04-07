package com.example.demo.dto;

import com.example.demo.model.Team;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlayerSoccerDTO {
    private int id;
    @NotBlank(message = "không được để trống")
    private String name;
    @NotNull(message = "không được để trống")
    private String dateOfBirth;
    @NotBlank(message = "không được để trống")
    private String exp;
    @NotBlank(message = "không được để trống")
    private String location;
    private String img;
    private Team team;

    public PlayerSoccerDTO() {
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
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
}
