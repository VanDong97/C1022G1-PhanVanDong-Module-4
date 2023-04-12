package com.example.player_soccer.controller;

import com.example.player_soccer.model.Team;
import com.example.player_soccer.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin("*")
public class TeamController {
    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public List<Team> showList(){
        return iTeamService.findAll();
    }
}
