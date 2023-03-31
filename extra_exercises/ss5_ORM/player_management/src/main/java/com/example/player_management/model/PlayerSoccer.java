package com.example.player_management.model;

import javax.persistence.*;

@Entity
@Table(name = "player_soccer")
public class PlayerSoccer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "experience")
    private String experience;
    @Column(name = "location")
    private String location;
    @Column(name = "img")
    private String img;

    public PlayerSoccer() {
    }

    public PlayerSoccer(int id, String name, String dateOfBirth, String experience, String location, String img) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.img = img;
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
}
