package com.example.player_soccer.controller;

import com.example.player_soccer.dto.PlayerSoccerDTO;
import com.example.player_soccer.model.PlayerSoccer;
import com.example.player_soccer.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/player")
public class PlayerSoccerRestController {

    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @GetMapping("")
    public ResponseEntity<Page<PlayerSoccer>> showListPlayer(@RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(iPlayerSoccerService.findAll(PageRequest.of(page, 3)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createPlayer(@RequestBody PlayerSoccerDTO playerSoccerDTO) {
        iPlayerSoccerService.createPlayer(playerSoccerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailPlayer(@PathVariable int id) {
        iPlayerSoccerService.findById(id);
        return new ResponseEntity<>(iPlayerSoccerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/detail/{id}")
    public ResponseEntity editPlayer(@RequestBody PlayerSoccerDTO playerSoccerDTO) {
        iPlayerSoccerService.editPlayer(playerSoccerDTO);
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(playerSoccerDTO.getId()).get();
        return new ResponseEntity(playerSoccer, HttpStatus.OK);
    }
}
