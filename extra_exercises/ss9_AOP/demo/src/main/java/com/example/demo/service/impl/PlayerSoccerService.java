package com.example.demo.service.impl;

import com.example.demo.dto.PlayerSoccerDTO;
import com.example.demo.model.PlayerSoccer;
import com.example.demo.repository.IPlayerSoccerRepository;
import com.example.demo.service.IPlayerSoccerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerSoccerService implements IPlayerSoccerService {
    @Autowired
    private IPlayerSoccerRepository iPlayerSoccerRepository;

    @Override
    public Page<PlayerSoccer> findAll(String name, PageRequest pageRequest) {
        return iPlayerSoccerRepository.findAllByNameContaining(name,pageRequest);
    }

    @Override
    public Optional<PlayerSoccer> findById(int id) {
        return iPlayerSoccerRepository.findById(id);
    }

    @Override
    public void createPlayer(PlayerSoccerDTO playerSoccerDTO) {
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDTO,playerSoccer);
        iPlayerSoccerRepository.save(playerSoccer);
    }
}
