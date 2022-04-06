package accurate.desafio2022.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String nome;
	private String telefone;
	private String senha;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	@OneToMany(mappedBy = "autor")
	private List<Item> item;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Usuario(String nome, String telefone, String login, String senha) {
		this.nome = nome;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
