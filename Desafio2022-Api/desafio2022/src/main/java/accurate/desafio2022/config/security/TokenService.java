package accurate.desafio2022.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import accurate.desafio2022.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${desafio.jwt.secret}")
	private String secret;
	
	@Value("${desafio.jwt.expiration}")
	private String expiration;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
					.setIssuer("API do sistema de achados e perdidos da Accurate")
					.setSubject(usuario.getId().toString())
					.setIssuedAt(hoje)
					.setExpiration(dataExpiracao)
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
		
	}

}
