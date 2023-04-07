package com.example.demo.service;

import com.example.demo.dto.PlayerSoccerDTO;
import com.example.demo.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IPlayerSoccerService {

    Page<PlayerSoccer> findAll(String name, PageRequest pageRequest);

    Optional<PlayerSoccer> findById(int id);

    void createPlayer(PlayerSoccerDTO playerSoccerDTO);
}
