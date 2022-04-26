package accurate.desafio2022.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import accurate.desafio2022.controller.dto.UsuarioDTO;
import accurate.desafio2022.controller.form.UsuarioForm;
import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/")
	@Transactional
	public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioForm insercaoDTO, 
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = insercaoDTO.conveter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuario/{id}")
				.buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
	}
}
