package com.example.player_management.repository;

import com.example.player_management.model.PlayerSoccer;

import java.util.List;

public interface IPlayerSoccerRepository {
    List<PlayerSoccer> findAll();
    PlayerSoccer findById(int id);
    void deletePlayer(int id);
    void createPlayer(PlayerSoccer playerSoccer);
    void editPlayer(PlayerSoccer playerSoccer);
}
