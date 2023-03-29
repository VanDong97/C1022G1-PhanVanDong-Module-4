package com.example.movie.model.cinema;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String branchName;

    @JsonManagedReference
    @OneToMany(mappedBy = "branch")
    private Set<Cinema> cinemaSet;

    public Branch(Integer id) {
        this.id = id;
    }

    public Branch() {
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

    public Set<Cinema> getCinemaSet() {
        return cinemaSet;
    }

    public void setCinemaSet(Set<Cinema> cinemaSet) {
        this.cinemaSet = cinemaSet;
    }
}
