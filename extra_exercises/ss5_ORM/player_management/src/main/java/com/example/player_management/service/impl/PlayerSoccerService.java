package com.example.player_management.service.impl;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.IPLayerSoccerRepository;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerSoccerService implements IPlayerSoccerService {

    @Autowired
    private IPLayerSoccerRepository ipLayerSoccerRepository;

    @Override
    public List<PlayerSoccer> findAll() {
        return ipLayerSoccerRepository.findAll();
    }

    @Override
    public PlayerSoccer findById(int id) {
        return ipLayerSoccerRepository.findById(id);
    }

    @Override
    public void deletePlayer(int id) {
        ipLayerSoccerRepository.deletePlayer(id);
    }

    @Override
    public void createPlayer(PlayerSoccer playerSoccer) {
        ipLayerSoccerRepository.createPlayer(playerSoccer);
    }

    @Override
    public void editPlayer(PlayerSoccer playerSoccer) {
        ipLayerSoccerRepository.editPlayer(playerSoccer);
    }
}
