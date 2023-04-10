package com.example.player_soccer.controller;

import com.example.player_soccer.model.PlayerSoccer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class PlayerSoccerTalkController {

    @GetMapping("/talk")
    public String getTalkRoom(@SessionAttribute("playerTalkList") List<PlayerSoccer> playerSoccerList, Model model) {
        model.addAttribute("playerTalk", playerSoccerList);
        return "/talk_list";
    }
}
