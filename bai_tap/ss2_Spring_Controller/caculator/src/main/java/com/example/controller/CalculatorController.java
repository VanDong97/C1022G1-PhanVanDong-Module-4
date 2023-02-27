package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showForm() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(required = false) Double fistNumber, Double secondNumber, String calculation, Model model) {
        if (fistNumber == null && secondNumber == null) {
            return "/calculator";
        }
        String calculationMessage = "";
        double result = calculatorService.formCalculation(calculation, fistNumber, secondNumber);
        switch (calculation) {
            case "Addition":
                calculationMessage = "Addition";
                break;
            case "Subtraction":
                calculationMessage = "Subtraction";
                break;
            case "Multiplication":
                calculationMessage = "Multiplication";
                break;
            case "Division":
                calculationMessage = "Division";
                break;
        }
        model.addAttribute("fistNumber", fistNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("result", result);
        model.addAttribute("calculationMessage", calculationMessage);
        return "/calculator";
    }
}
