package com.shcheglov.bank.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value = "/")
	public String redirect() {
		return "redirect:main.html";
	}

	@RequestMapping(value = "/main")
	public String openMain() {
		return "main";
	}

}
