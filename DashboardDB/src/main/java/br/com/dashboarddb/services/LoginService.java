package br.com.dashboarddb.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public Boolean validateUser(String userId, String password) {
		return userId.equalsIgnoreCase("Marcos") && password.equalsIgnoreCase("Teste");
	}
}
