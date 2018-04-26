package com.rph.inventorysales.InventorySales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
/*
	@RequestMapping("/")
	public String index() {
		return "index";
	}*/
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/users")
	public String user() {
		return "users";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/403")
    public String errorPage() {
        return "/error/403";
    }
}
