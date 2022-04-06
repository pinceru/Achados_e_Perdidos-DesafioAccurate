package accurate.desafio2022.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private LocalDateTime data;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Status status;
	@ManyToOne
	private Localizacao localizacao;
	@OneToOne(cascade = CascadeType.ALL)
	private Historico historico;
	
	public Item() {
		
	}
	
	public Item(String descricao, Usuario usuario, Status status, LocalDateTime data, Localizacao localizacao) {
		this.descricao = descricao;
		this.autor = usuario;
		this.status = status;
		this.data = data;
		this.localizacao = localizacao;
	}
}
