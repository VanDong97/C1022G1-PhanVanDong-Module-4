package com.example.player_soccer.controller;

import com.example.player_soccer.model.PlayerSoccer;
import com.example.player_soccer.service.IPlayerSoccerService;
import com.example.player_soccer.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/player")
@SessionAttributes("playerTalkList")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService iPlayerSoccerService;

    @Autowired
    private ITeamService iTeamService;

    @ModelAttribute("playerTalkList")
    public List<PlayerSoccer> playerSoccerList() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public String showListPlayer(@RequestParam(defaultValue = "0") int page, Model model, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("playerSoccerList", iPlayerSoccerService.findAll(name, PageRequest.of(page, 3)));
        return "/list";
    }

    @GetMapping("/detail")
    public String detailPlayer(@RequestParam Integer id, Model model, @CookieValue("countPlayer") Integer countPlayer,
                               HttpServletResponse response, RedirectAttributes redirect) {
        Cookie cookie = new Cookie("countPlayer", ++countPlayer + "");
        response.addCookie(cookie);
        cookie.setMaxAge(1 * 24 * 60 * 60);
        redirect.addFlashAttribute("countPlayer", countPlayer);
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id).get();
        model.addAttribute("playerSoccer", playerSoccer);
        return "/detail";
    }

    @GetMapping("add-room/detail")
    public String addRoom(@RequestParam("id") Integer id, RedirectAttributes redirect,
                          @ModelAttribute("playerTalkList") List<PlayerSoccer> playerSoccers) {
        PlayerSoccer playerSoccer = iPlayerSoccerService.findById(id).get();
        redirect.addFlashAttribute("msg", "Thêm vào danh sách yêu thích thành công");
        playerSoccers.add(playerSoccer);
        return "redirect:/player";
    }
}
