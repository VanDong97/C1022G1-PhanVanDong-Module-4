package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String,String> searchList = new HashMap<>();
    static {
        searchList.put("Car","Xe hơi");
        searchList.put("Smartphone","Điện thoại thông minh");
        searchList.put("People","Con người");
    }

    @GetMapping("/dictionary")
    public String search(@RequestParam (required = false) String dictionary , Model model){
        if (dictionary == null){
            model.addAttribute("/dictionary","Không thấy");
            return "/dictionary";
        }
        model.addAttribute("result",searchList.get(dictionary));
        return "/dictionary";
    }
}
