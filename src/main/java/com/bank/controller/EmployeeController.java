package com.bank.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@PreAuthorize("hasAnyRole('EMPLOYEE')")
@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @GetMapping("/dashboard")
    @ResponseBody
    public String securedHello() {
        return "employee dashboard";
    }

}