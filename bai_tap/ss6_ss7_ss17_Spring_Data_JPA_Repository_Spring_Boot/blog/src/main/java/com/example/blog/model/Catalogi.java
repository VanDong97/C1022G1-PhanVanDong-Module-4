package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "cataloging")
public class Catalogi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogi_id")
    private Integer id;

    @Column(name = "titleCa",nullable = false)
    private String titleCa;

    @OneToMany(mappedBy = "catalogi")
    private Set<Blog> blogs;

    public Catalogi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleCa() {
        return titleCa;
    }

    public void setTitleCa(String titleCa) {
        this.titleCa = titleCa;
    }
}
