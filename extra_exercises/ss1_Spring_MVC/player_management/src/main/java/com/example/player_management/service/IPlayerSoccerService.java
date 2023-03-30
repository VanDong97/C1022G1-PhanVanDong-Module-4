package com.example.player_management.service;

import com.example.player_management.model.PlayerSoccer;

import java.util.List;

public interface IPlayerSoccerService {
    List<PlayerSoccer> findAll();
    PlayerSoccer findById(int id);
    void deleteSoccerPlayer(int id);
    Object createPlayerSoccer(PlayerSoccer playerSoccer);
    void editPlayerSoccer(PlayerSoccer playerSoccer);
}
