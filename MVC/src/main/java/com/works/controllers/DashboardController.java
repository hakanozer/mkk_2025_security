package com.works.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final HttpServletRequest req;

    @GetMapping("dashboard")
    public String login(){
        boolean loggedIn = req.getSession().getAttribute("user") == null;
        if(loggedIn){
            return "redirect:/";
        }
        return "dashboard";
    }


}
