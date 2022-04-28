package accurate.desafio2022.service;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.UsuarioRepository;

@Service
public class UsuarioService {

	public Usuario getUsuario(UsuarioRepository usuarioRepository,
			@NotNull @NotEmpty @Size(max = 50, min = 1) String nome, 
			@Size(max = 15, min = 14) String telefone) {
		
		Optional<Usuario> optional = usuarioRepository.findByNomeAndTelefone(nome, telefone);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return usuarioRepository.save(new Usuario(nome, telefone));
		}
	}

}
