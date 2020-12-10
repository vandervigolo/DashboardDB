package br.com.dashboarddb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.dashboarddb.services.LoginService;

@Controller
@SessionAttributes("name")
@RequestMapping("login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping(value = "/")
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@PostMapping(value = "/")
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		Boolean isValidUser = loginService.validateUser(name, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "welcome";
		
	}
}

