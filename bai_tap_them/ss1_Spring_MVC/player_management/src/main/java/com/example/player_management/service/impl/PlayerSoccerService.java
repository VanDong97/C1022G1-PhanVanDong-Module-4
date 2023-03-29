package com.example.player_management.service.impl;
import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.IPlayerSoccerRepository;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerSoccerService implements IPlayerSoccerService {

    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public List<PlayerSoccer> findAll() {
        return iPlayerSoccerRepository.findAll();
    }

    @Override
    public PlayerSoccer findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }

    @Override
    public void deleteSoccerPlayer(int id) {
        iPlayerSoccerRepository.deleteSoccerPlayer(id);
    }
}
