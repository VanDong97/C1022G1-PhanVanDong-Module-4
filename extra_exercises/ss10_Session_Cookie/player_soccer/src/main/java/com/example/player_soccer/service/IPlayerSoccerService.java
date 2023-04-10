package com.example.player_soccer.service;

import com.example.player_soccer.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IPlayerSoccerService {

    Page<PlayerSoccer> findAll(String name, PageRequest pageRequest);

    Optional<PlayerSoccer> findById(int id);
}
