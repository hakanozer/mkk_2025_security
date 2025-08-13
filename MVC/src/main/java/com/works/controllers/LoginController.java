package com.works.controllers;

import com.works.services.TinkEncDec;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final HttpServletRequest req;
    private final TinkEncDec tinkEncDec;

    @GetMapping("")
    public String login(Model model){
        String uuid = UUID.randomUUID().toString();
        req.getSession().setAttribute("uuid", uuid);
        model.addAttribute("csrf", uuid);
        return "login";
    }

    @PostMapping("login")
    public String loginUser(@RequestParam String data, @RequestParam String csrf, Model model) {
        Object uuid = req.getSession().getAttribute("uuid");
        String cipherText = tinkEncDec.encrypt(data);
        System.out.println("cipherText: " + cipherText);
        String decrypted = tinkEncDec.decrypt(cipherText);
        System.out.println("decrypted: " + decrypted);
        if (uuid != null && uuid.toString().equals(csrf)) {
            model.addAttribute("data", data);
            req.getSession().setAttribute("user", data);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

}
