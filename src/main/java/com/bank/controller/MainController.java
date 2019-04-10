package com.bank.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
	@RequestMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken))
		    return "redirect:/";
		
		return "login";
	  }
	
	  @RequestMapping("/login-error")
	  public String loginError(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(auth instanceof AnonymousAuthenticationToken))
			return "redirect:/";
		
	    model.addAttribute("loginError", true);
	    return "login";
	  }
}
