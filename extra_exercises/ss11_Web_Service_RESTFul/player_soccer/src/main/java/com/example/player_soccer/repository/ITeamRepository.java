package com.example.player_soccer.repository;

import com.example.player_soccer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
