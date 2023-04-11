package com.example.player_soccer.service;

import com.example.player_soccer.dto.PlayerSoccerDTO;
import com.example.player_soccer.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayerSoccerService {

    Page<PlayerSoccer> findAll(PageRequest pageRequest);

    Optional<PlayerSoccer> findById(int id);

    void createPlayer(PlayerSoccerDTO playerSoccerDTO);

    void editPlayer(PlayerSoccerDTO playerSoccerDTO);
}
