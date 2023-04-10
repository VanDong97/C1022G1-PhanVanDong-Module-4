package com.example.player_management.service;

import com.example.player_management.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IPlayerSoccerService {
    Page<PlayerSoccer> findAll(String name, PageRequest pageRequest);

    Optional<PlayerSoccer> findById(int id);

    void updatePlayer(PlayerSoccer playerSoccer);

    void deletePlayer(PlayerSoccer playerSoccer);

    List<PlayerSoccer> footballTeam();
}
