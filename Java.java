package com.example.wealth;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
public class WealthApp {

    public static void main(String[] args) {
        SpringApplication.run(WealthApp.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double income,
                            @RequestParam double expenses,
                            @RequestParam double savings,
                            @RequestParam double investments,
                            Model model) {
        double result = income - expenses + savings + investments;
        model.addAttribute("result", result);
        return "index";
    }
}