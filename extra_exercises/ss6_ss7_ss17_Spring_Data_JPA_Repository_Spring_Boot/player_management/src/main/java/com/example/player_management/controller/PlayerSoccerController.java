package com.example.player_management.controller;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerSoccerController {

    @Autowired
    private IPlayerSoccerService  iPlayerSoccerService;

    @GetMapping("")
    public String showSoccerPlayerList(@PageableDefault(size = 2) Pageable pageable
            , @RequestParam(required = false) String name , Model model) {
        if (name == null) {
            name = "";
        }

        Sort sort = null;
        if (name == name){
            sort = Sort.by("dateOfBirth").ascending();
        }else {
            sort = Sort.by("name").ascending();
        }
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<PlayerSoccer> playerSoccerPage = iPlayerSoccerService.findAll(name, sortedPageable);
        model.addAttribute("playerSoccerList", playerSoccerPage);
        model.addAttribute("name", name);
        List<Integer> pageNumberList = new ArrayList<>();
        for (int i = 1; i <= playerSoccerPage.getTotalPages(); i++) {
            pageNumberList.add(i);
        }
        model.addAttribute("pageNumberList", pageNumberList);
        return "/list";
    }

    @GetMapping("/detail")
    public String detailSoccerPlayer(@RequestParam int id, Model model) {
        PlayerSoccer soccerPlayer = iPlayerSoccerService.findById(id).get();
        model.addAttribute("soccerPlayer", soccerPlayer);
        return "/detail";
    }

    @GetMapping("/delete")
    public String deleteSoccerPlayer(@RequestBody PlayerSoccer playerSoccer) {
        iPlayerSoccerService.deletePlayer(playerSoccer);
        return "redirect:/player";
    }

    @GetMapping("/create")
    public String showCreateSoccerPlayer(Model model) {
        model.addAttribute("playerSoccer", new PlayerSoccer());
        return "/create";
    }

    @PostMapping("/create")
    public String createSoccerPlayer(@ModelAttribute PlayerSoccer playerSoccer) {
        iPlayerSoccerService.createPlayer(playerSoccer);
        return "redirect:/player";
    }

    @GetMapping("/edit")
    public String showUpdateSoccerPlayer(@RequestParam int id, Model model) {
        model.addAttribute("soccerPlayer", iPlayerSoccerService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateSoccerPlayer(@ModelAttribute PlayerSoccer playerSoccer) {
        iPlayerSoccerService.editPlayer(playerSoccer);
        return "redirect:/player";
    }
}
