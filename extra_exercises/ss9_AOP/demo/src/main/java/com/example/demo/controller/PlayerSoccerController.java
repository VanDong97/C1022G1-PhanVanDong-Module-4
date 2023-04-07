package com.example.demo.controller;

import com.example.demo.dto.PlayerSoccerDTO;
import com.example.demo.model.PlayerSoccer;
import com.example.demo.service.IPlayerSoccerService;
import com.example.demo.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;
    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showListPlayer(Model model, @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String name){
        model.addAttribute("playerSoccerList",iPlayerSoccerService.findAll(name, PageRequest.of(page,2)));
        return "/list";
    }

    @GetMapping("/detail")
    public String detailPlayer(@RequestParam int id,Model model){
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id).get();
        model.addAttribute("playerSoccer",playerSoccer);
        return "/detail";
    }

  @GetMapping("/create")
    public String showFormCreatePlayer(Model model){
        model.addAttribute("playerSoccerDTO",new PlayerSoccerDTO());
        model.addAttribute("teamList",iTeamService.findAll());
        return "/create";
  }

  @PostMapping("/create")
    public String createPlayer(@ModelAttribute("playerSoccerDTO")PlayerSoccerDTO playerSoccerDTO){
        iPlayerSoccerService.createPlayer(playerSoccerDTO);
        return "redirect:/player";
  }
}
