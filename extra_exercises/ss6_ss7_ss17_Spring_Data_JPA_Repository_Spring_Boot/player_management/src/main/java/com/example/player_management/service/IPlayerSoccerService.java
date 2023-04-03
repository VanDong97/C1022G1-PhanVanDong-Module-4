package com.example.player_management.service;

import com.example.player_management.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayerSoccerService {
    Page<PlayerSoccer> findAll(String name, Pageable pageable);
    Optional<PlayerSoccer> findById(int id);
    void createPlayer(PlayerSoccer playerSoccer);
    void deletePlayer(PlayerSoccer playerSoccer);
    void editPlayer(PlayerSoccer playerSoccer);
}
