package accurate.desafio2022.controller.dto;

import accurate.desafio2022.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String telefone;
	private String login;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.nome = usuario.getNome();
		this.telefone = usuario.getTelefone();
	}

}
