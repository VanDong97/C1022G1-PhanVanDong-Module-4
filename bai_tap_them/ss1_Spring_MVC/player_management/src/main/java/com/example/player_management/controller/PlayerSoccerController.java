package com.example.player_management.controller;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/player")
public class PlayerSoccerController {

    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @GetMapping("")
    public String showListPlayer(Model model){
        model.addAttribute("playerSoccerList",iPlayerSoccerService.findAll());
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detailPlayerSoccer(@PathVariable("id") int id,Model model){
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id);
        model.addAttribute("playerSoccer",playerSoccer);
        return "/detail";
    }

    @GetMapping("/delete")
    public String deletePlayerSoccer(@RequestParam int id){
        iPlayerSoccerService.deleteSoccerPlayer(id);
        return "redirect:/player";
    }

}
