package com.example.player_management.repository;

import com.example.player_management.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerSoccerRepository extends JpaRepository<PlayerSoccer, Integer> {
    Page<PlayerSoccer> findAllByNameContaining(String name, Pageable pageable);
}
