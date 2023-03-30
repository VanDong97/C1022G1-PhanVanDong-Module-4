package com.example.player_management.controller;

import com.example.player_management.model.PlayerSoccer;
import com.example.player_management.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/detele")
    public String deletePlayerSoccer(@RequestParam int id){
        iPlayerSoccerService.deletePlayer(id);
        return "redirect:/player";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("playerSoccer",new PlayerSoccer());
        return "/create";
    }

    @PostMapping("/create")
    public String createPLayerSoccer(@ModelAttribute PlayerSoccer playerSoccer, BindingResult bindingResult, RedirectAttributes attributes){
        iPlayerSoccerService.createPlayer(playerSoccer);
        attributes.addFlashAttribute("msg","Thêm Mới Thành Công");
        return "redirect:/player";
    }
    @GetMapping("/edit/{id}")
    public String editForm(Model model,@PathVariable int id){
        model.addAttribute("playerSoccer",this.iPlayerSoccerService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String updatePlayer(@ModelAttribute PlayerSoccer playerSoccer, RedirectAttributes redirectAttributes){
        this.iPlayerSoccerService.editPlayer(playerSoccer);
        redirectAttributes.addFlashAttribute("msg","Chỉnh Sửa Thành Công");
        return "redirect:/player";
    }
}
