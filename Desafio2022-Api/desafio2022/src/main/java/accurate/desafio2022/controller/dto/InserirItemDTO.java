package accurate.desafio2022.controller.dto;

import java.util.Optional;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.StatusRepository;
import accurate.desafio2022.repository.UsuarioRepository;
import lombok.Data;

@Data
public class InserirItemDTO {
	private String nome;
	private String telefone;
	private String descricao;
	private String status;
	private String data;
	
	public Item converter(UsuarioRepository usuarioRepository, StatusRepository statusRepository) {
		Status statusObj = statusRepository.findByNome(status);
		Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
		if(usuario.isPresent()) {
			return new Item(descricao, usuario.get(), statusObj, data);
		} else {
			Usuario novoUsuario = usuarioRepository.save(new Usuario(nome, telefone));
			return new Item(descricao, novoUsuario, statusObj, data);
		}
	}
}
