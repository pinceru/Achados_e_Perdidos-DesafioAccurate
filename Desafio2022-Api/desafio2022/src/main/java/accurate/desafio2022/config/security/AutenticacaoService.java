package accurate.desafio2022.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new UsernameNotFoundException("Dados inválidos");
		}
	}

}
