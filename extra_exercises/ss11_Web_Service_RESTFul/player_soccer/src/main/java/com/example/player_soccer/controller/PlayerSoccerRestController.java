package com.example.player_soccer.controller;

import com.example.player_soccer.dto.PlayerSoccerDTO;
import com.example.player_soccer.model.PlayerSoccer;
import com.example.player_soccer.model.Team;
import com.example.player_soccer.service.IPlayerSoccerService;
import com.example.player_soccer.service.ITeamService;
import com.example.player_soccer.service.impl.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/player")
@CrossOrigin("*")
public class PlayerSoccerRestController {

    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @Autowired
    private ITeamService iTeamService;

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

    @PostMapping("/edit/{id}")
    public ResponseEntity editPlayer(@RequestBody PlayerSoccerDTO playerSoccerDTO) {
        iPlayerSoccerService.editPlayer(playerSoccerDTO);
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(playerSoccerDTO.getId()).get();
        return new ResponseEntity(playerSoccer, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
