package com.example.movie.model.movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String actor;
    private String director;
    private String content;
    private String time;
    @Column(columnDefinition = "Date", name = "start_day")
    private String startDay;
    @Column(columnDefinition = "Date",name = "end_day")
    private String endDay;
    private String country;
    private String img;
    @ManyToOne
    @JoinColumn(name = "movie_type_id",referencedColumnName = "id")
    @JsonBackReference
    private MovieType movieType;
    @JoinColumn(name = "is_delete")
    private Boolean isDelete=false;
    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }
}
