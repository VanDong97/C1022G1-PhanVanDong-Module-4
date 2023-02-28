package com.example.controller;

import com.example.model.MailBox;
import com.example.service.impl.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/mailBox")
public class MailBoxController {

    @Autowired
    IMailBoxService iMailBoxService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("mailBox",iMailBoxService.mailBox());
        model.addAttribute("languageList", Arrays.asList("English","Vietnamese","Japanese","Chinese"));
        model.addAttribute("pageSizeList",Arrays.asList("5","10","15","25","50","100"));
        return "/mail";
    }

    @PostMapping("")
    public String formUpdate(@ModelAttribute MailBox mailBox, Model model){
        iMailBoxService.updateEmail(mailBox);
        model.addAttribute("mailBox",mailBox);
        return "/update";
    }
}
