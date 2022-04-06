package accurate.desafio2022.controller.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class LoginForm {
	private String login;
	private String senha;
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}
	
	
}
