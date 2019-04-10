package com.bank.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@PreAuthorize("hasAnyRole('USER')")
@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/home")
    public String securedHello() {
        return "user/details";
    }

}