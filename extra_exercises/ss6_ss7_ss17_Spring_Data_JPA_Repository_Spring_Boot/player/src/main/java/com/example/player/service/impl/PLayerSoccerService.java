package com.example.player.service.impl;

import com.example.player.model.PlayerSoccer;
import com.example.player.repository.IPlayerSoccerRepository;
import com.example.player.service.IPLayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PLayerSoccerService implements IPLayerSoccerService {

    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public Page<PlayerSoccer> findAll(String name,PageRequest pageRequest) {
        return iPlayerSoccerRepository.findAllByNameContaining(name,pageRequest);
    }

    @Override
    public Optional<PlayerSoccer> findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }

    @Override
    public void deletePlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.delete(playerSoccer);
    }

    @Override
    public void createPlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.save(playerSoccer);
    }

    @Override
    public void editPlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.save(playerSoccer);
    }
}
