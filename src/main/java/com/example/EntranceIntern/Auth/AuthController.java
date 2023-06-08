package com.example.EntranceIntern.Auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EntranceIntern.User.User;


@Controller
@RequestMapping()
public class AuthController {

    @Autowired
    private AuthServices authServices;

    
    @GetMapping("/login")
    String LoginPage (){

       
        return "auth/login.html";
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/register")
    String RegisterPage(Model model){

        User userDto = new User();
        model.addAttribute("userDto", userDto);

        return "auth/register.html";
    }

    @PostMapping("/register")
    public String Register(User userDto, Model model){

    System.out.println(userDto);
    authServices.save(userDto);

     return "redirect:/";
    }


}
