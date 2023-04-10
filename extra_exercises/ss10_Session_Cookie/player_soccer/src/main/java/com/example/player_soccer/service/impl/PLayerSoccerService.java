package com.example.player_soccer.service.impl;

import com.example.player_soccer.model.PlayerSoccer;
import com.example.player_soccer.repository.IPlayerSoccerRepository;
import com.example.player_soccer.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PLayerSoccerService implements IPlayerSoccerService {

    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public Page<PlayerSoccer> findAll(String name, PageRequest pageRequest) {
        return iPlayerSoccerRepository.findAllByNameContaining(name, pageRequest);
    }

    @Override
    public Optional<PlayerSoccer> findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }
}
