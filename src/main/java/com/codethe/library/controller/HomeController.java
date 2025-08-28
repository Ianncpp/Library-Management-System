package com.codethe.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String name, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(@ModelAttribute("userName") String name, Model model) {
        System.out.println("Name in model: " + model.getAttribute("name"));
//        model.addAttribute("userName", name);
        return "home";
    }

    @GetMapping("/meme")
    public String showMeme() {
        return "meme";
    }
}