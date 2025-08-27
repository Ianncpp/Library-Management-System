package com.codethe.library.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("name") String username, HttpSession session) {
        session.setAttribute("userName", username); // salvăm direct în sesiune
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        String name = (String) session.getAttribute("userName");
        if (name == null || name.isEmpty()) {
            name = "Guest";
        }
        model.addAttribute("userName", name);
        return "home";
    }

    @GetMapping("/meme")
    public String showMeme() {
        return "meme";
    }
}