package com.example.registration_form.controller;

import com.example.registration_form.dto.UserDTO;
import com.example.registration_form.model.User;
import com.example.registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("")
    private String showUserList(Model model){
        model.addAttribute("listUser",iUserService.listAll());
        return "/list";
    }

    @GetMapping("/showFormCreate")
    private String showFormCreate(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("")
    private String validateUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        this.iUserService.createUser(user);
        redirectAttributes.addFlashAttribute("msg","msg.createUser");
        return "redirect:/user";
    }
}
