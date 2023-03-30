package com.example.song_form.service;

import com.example.song_form.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> listAll();

    void createSong(Song song);
}
