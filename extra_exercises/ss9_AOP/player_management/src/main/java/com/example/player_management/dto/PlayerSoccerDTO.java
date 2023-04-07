package com.example.player_management.dto;

import com.example.player_management.model.Team;

import javax.validation.constraints.Max;

public class PlayerSoccerDTO {
    private int id;
    private String name;
    private String dateOfBirth;
    private String experience;
    private String location;
    private String img;
    private String status;
    private int register;
    @Max(value = 11, message = "{quantity.max}")
    private int quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    public void registerPlayer(PlayerSoccerDTO playerSoccerDTO) {
        if (register < 11) {
            playerSoccerDTO.setStatus("Đã đăng kí");
            register++;
        }
    }

    public void unsubscribePlayer(PlayerSoccerDTO playerSoccerDTO) throws Exception {
        if (register > 11) {
            playerSoccerDTO.setStatus("Số cầu thủ đăng kí đã đủ");
            register--;
            throw new Exception("Số lượng cầu thủ đăng kí đã đủ.");
        }
    }
}
