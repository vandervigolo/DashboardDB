package br.com.dashboarddb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sun.faces.action.RequestMapping;

@Controller
@RequestMapping("")
public class home {

	@GetMapping(value = {"/", "/home"})
	public String showHomePage() {
		return "home";
	}
}