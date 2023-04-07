package com.example.player_management.controller;

import com.example.player_management.dto.PlayerSoccerDTO;
import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.service.IPlayerSoccerService;
import com.example.player_management.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/player")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @Autowired
    private ITeamService iTeamService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("playerSoccerList", iPlayerSoccerService.findAll(name, PageRequest.of(page, 2)));
        return "/list";
    }

    @GetMapping("/detail")
    public String detailPlayer(@RequestParam int id, Model model) {
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id).get();
        model.addAttribute("playerSoccer", playerSoccer);
        return "/detail";
    }

    @GetMapping("/register")
    public String performRegisterPlayer(@RequestParam Integer id) {
        Optional<PlayerSoccer> playerSoccerDTO = iPlayerSoccerService.findById(id);
        performRegisterPlayer(id);
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDTO, playerSoccer);
        iPlayerSoccerService.updatePlayer(playerSoccer);
        return "/redirect:/player";

    }

    @GetMapping("/unsubscribe")
    public String performUnsubscribePlayer(@RequestParam PlayerSoccerDTO status, Integer id) throws Exception {
        Optional<PlayerSoccer> playerSoccerDTO = iPlayerSoccerService.findById(id);
        performUnsubscribePlayer(status, id);
        PlayerSoccer playerSoccer = new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDTO, playerSoccer);
        iPlayerSoccerService.updatePlayer(playerSoccer);
        return "/redirect:/player";
    }

    @ExceptionHandler(Exception.class)
    public String handle() {
        return "/error";
    }

    @GetMapping("/detele")
    public String deletePlayer(@RequestParam int id) {
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id).get();
        iPlayerSoccerService.deletePlayer(playerSoccer);
        return "redirect:/player";
    }
}
