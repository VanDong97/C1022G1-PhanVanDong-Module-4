package com.example.player.service;

import com.example.player.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IPLayerSoccerService {

    Page<PlayerSoccer> findAll(String name,PageRequest pageRequest);

    Optional<PlayerSoccer> findById(int id);

    void deletePlayer(PlayerSoccer playerSoccer);

    void createPlayer(PlayerSoccer playerSoccer);

    void editPlayer(PlayerSoccer playerSoccer);
}
