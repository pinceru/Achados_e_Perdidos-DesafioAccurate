package accurate.desafio2022.controller.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accurate.desafio2022.model.Usuario;
import lombok.Data;

@Data
public class UsuarioForm {

	private String nome;
	private String senha;
	private String telefone;
	private String login;
	
	public Usuario conveter() {
		String novaSenha = new BCryptPasswordEncoder().encode(senha);
		return new Usuario(nome, telefone, login, novaSenha);
	}

}
