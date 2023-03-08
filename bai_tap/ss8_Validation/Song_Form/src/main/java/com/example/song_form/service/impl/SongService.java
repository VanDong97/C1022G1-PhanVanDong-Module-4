package com.example.song_form.service.impl;

import com.example.song_form.model.Song;
import com.example.song_form.repository.ISongRepository;
import com.example.song_form.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    private ISongRepository iSongRepository;
    @Override
    public List<Song> listAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void createSong(Song song) {
        iSongRepository.save(song);
    }
}
