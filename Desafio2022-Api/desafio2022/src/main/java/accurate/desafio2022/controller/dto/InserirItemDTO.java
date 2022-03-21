package accurate.desafio2022.controller.dto;

import java.util.Optional;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.UsuarioRepository;
import lombok.Data;

@Data
public class InserirItemDTO {
	private String nome;
	private String telefone;
	private String descricao;
	private String status;
	
	public Item converter(UsuarioRepository usuarioRepository) {
		Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
		if(usuario.isPresent()) {
			return new Item(descricao, usuario.get());
		} else {
			Usuario novoUsuario = usuarioRepository.save(new Usuario(nome, telefone));
			return new Item(descricao, novoUsuario);
		}
	}
}
