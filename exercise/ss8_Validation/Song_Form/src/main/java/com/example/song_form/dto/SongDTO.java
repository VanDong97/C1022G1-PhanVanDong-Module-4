package com.example.song_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {

    @NotNull
    @NotBlank(message = "songName.notBlank")
    @Size(max = 800, message = "songName.size")
    @Pattern(regexp = "^[^@;,.=+\\\\-]+$\", message = \"songName.pattern")
    private String songName;

    @NotNull
    @NotBlank(message = "singer.notBlank")
    @Size(max = 300, message = "singer.size")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "singer.pattern")
    private String singer;

    @NotNull
    @NotBlank(message = "category.notBlank")
    @Size(max = 1000, message = "category.size")
    @Pattern(regexp = "^[^@;.=+\\-]+$", message = "category.pattern")
    private String category;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
