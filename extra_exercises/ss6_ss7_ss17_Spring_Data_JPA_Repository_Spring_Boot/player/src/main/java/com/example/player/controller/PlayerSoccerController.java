package com.example.player.controller;

import com.example.player.model.PlayerSoccer;
import com.example.player.service.IPLayerSoccerService;
import com.example.player.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerSoccerController {

    @Autowired
    private IPLayerSoccerService ipLayerSoccerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showListPlayer(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String name) {
        Sort sort = Sort.by("name").descending();
        model.addAttribute("playerSoccerList", ipLayerSoccerService.findAll(name, PageRequest.of(page, 2, sort)));
        return "/list_player";
    }

    @GetMapping("/detail")
    public String detailPlayer(@RequestParam int id, Model model) {
        PlayerSoccer playerSoccer = ipLayerSoccerService.findById(id).get();
        model.addAttribute("playerSoccer", playerSoccer);
        return "/detail";
    }

    @GetMapping("/delete")
    public String deletePlayer(@RequestParam int deleteId) {
        PlayerSoccer playerSoccer = ipLayerSoccerService.findById(deleteId).get();
        ipLayerSoccerService.deletePlayer(playerSoccer);
        return "redirect:/player";
    }

    @GetMapping("/create")
    public String showFormCreatePlayer(Model model) {
        model.addAttribute("playerSoccer", new PlayerSoccer());
        model.addAttribute("teamList", iTeamService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String createPlayer(@ModelAttribute PlayerSoccer playerSoccer) {
        ipLayerSoccerService.createPlayer(playerSoccer);
        return "redirect:/player";
    }

    @GetMapping("/edit")
    public String showFormEditPlayer(@RequestParam int id, Model model) {
        model.addAttribute("playerSoccer", ipLayerSoccerService.findById(id));
        model.addAttribute("team", iTeamService.findAll());
        return "/edit";
    }

    @PostMapping("/edit")
    public String editPlayer(@ModelAttribute PlayerSoccer playerSoccer) {
        ipLayerSoccerService.editPlayer(playerSoccer);
        return "redirect:/player";
    }
}
