package com.example.song_form.controller;

import com.example.song_form.dto.SongDTO;
import com.example.song_form.model.Song;
import com.example.song_form.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("singList", iSongService.listAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@Valid @ModelAttribute SongDTO songDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        iSongService.createSong(song);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "/redirect:/song";
    }
}
