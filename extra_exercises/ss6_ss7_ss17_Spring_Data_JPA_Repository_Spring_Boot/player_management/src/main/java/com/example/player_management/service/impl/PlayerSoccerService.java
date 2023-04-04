package com.example.player_management.service.impl;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.repository.IPlayerSoccerRepository;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PlayerSoccerService implements IPlayerSoccerService {

    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public Page<PlayerSoccer> findAll(String name, Pageable pageable, LocalDate startDate,LocalDate endDate) {
        return iPlayerSoccerRepository.findAllByNameAAndDateOfBirthBetween(name,pageable,startDate,endDate);
    }

    @Override
    public Optional<PlayerSoccer> findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }

    @Override
    public void createPlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.save(playerSoccer);
    }

    @Override
    public void deletePlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.delete(playerSoccer);
    }

    @Override
    public void editPlayer(PlayerSoccer playerSoccer) {
        iPlayerSoccerRepository.save(playerSoccer);
    }
}
