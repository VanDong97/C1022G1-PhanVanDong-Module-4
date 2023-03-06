package com.example.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "titleCa",nullable = false)
    private String titleCa;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category() {
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
