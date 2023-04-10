package com.example.player_management.service.impl;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.IPlayerSoccerRepository;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerSoccerService implements IPlayerSoccerService {

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

    @Override
    public void updatePlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.save(playerSoccer);
    }

    @Override
    public void deletePlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.delete(playerSoccer);
    }

    @Override
    public List<PlayerSoccer> footballTeam() {
        return iPlayerSoccerRepository.findAll();
    }
}
