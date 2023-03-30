package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService ;

    @GetMapping("")
    public String showProduct(@RequestParam (required = false) String productName, Model model){
        model.addAttribute("products",iProductService.listAll(productName));
        return "/list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String performCreate(@ModelAttribute Product product){
        iProductService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/detail")
    public String showProductDetail(@RequestParam int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/detail";
    }
    @GetMapping("/edit")
    public String showFormE(@RequestParam int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String performE(@ModelAttribute Product product,Model model){
        model.addAttribute("product",product);
        iProductService.update(product);
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int deleteId){
            iProductService.remove(deleteId);
            return "redirect:/product";
    }
}
