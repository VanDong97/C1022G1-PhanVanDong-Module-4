package com.example.movie.dto.movie;

public class MovieDTO {
    private Integer id;
    private String name;
    private String actor;
    private String director;
    private String content;
    private String time;
    private String startDay;
    private String endDay;
    private String country;
    private String img;
    private MovieTypeDTO movieTypeDTO;
    private Boolean isDelete=false;
    public MovieDTO() {
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

    public MovieTypeDTO getMovieTypeDTO() {
        return movieTypeDTO;
    }

    public void setMovieTypeDTO(MovieTypeDTO movieTypeDTO) {
        this.movieTypeDTO = movieTypeDTO;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
