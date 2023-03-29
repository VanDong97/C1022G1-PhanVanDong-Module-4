package com.example.movie.dto.cinema;

import java.util.Set;

public class BranchDTO {

    private Integer id;
    private String branchName;
    private Set<CinemaDTO> cinemaSet;

    public BranchDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Set<CinemaDTO> getCinemaSet() {
        return cinemaSet;
    }

    public void setCinemaSet(Set<CinemaDTO> cinemaDTOSet) {
        this.cinemaSet = cinemaDTOSet;
    }
}
