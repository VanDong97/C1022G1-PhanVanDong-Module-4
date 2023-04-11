package com.example.player_soccer.service.impl;

import com.example.player_soccer.dto.PlayerSoccerDTO;
import com.example.player_soccer.model.PlayerSoccer;
import com.example.player_soccer.repository.IPlayerSoccerRepository;
import com.example.player_soccer.service.IPlayerSoccerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerSoccerService implements IPlayerSoccerService {

    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public Page<PlayerSoccer> findAll(PageRequest pageRequest) {
        return iPlayerSoccerRepository.findAll(pageRequest);
    }

    @Override
    public Optional<PlayerSoccer> findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }

    @Override
    public void createPlayer(PlayerSoccerDTO playerSoccerDTO) {
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDTO, playerSoccer);
        iPlayerSoccerRepository.save(playerSoccer);
    }

    @Override
    public void editPlayer(PlayerSoccerDTO playerSoccerDTO) {
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDTO, playerSoccer);
        iPlayerSoccerRepository.save(playerSoccer);
    }
}
