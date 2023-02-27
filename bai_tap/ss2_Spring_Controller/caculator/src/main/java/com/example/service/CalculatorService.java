package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double formCalculation(String calculation, double fistNumber, double secondNumber) {
        switch (calculation) {
            case "Addition":
                return fistNumber + secondNumber;
            case "Subtraction":
                return fistNumber - secondNumber;
            case "Multiplication":
                return fistNumber * secondNumber;
            case "Division":
                if (secondNumber != 0) {
                    return fistNumber / secondNumber;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
