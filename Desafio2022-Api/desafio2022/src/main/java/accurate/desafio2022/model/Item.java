package accurate.desafio2022.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private LocalDate data;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Status status;
	
	public Item() {
		
	}
	
	public Item(String descricao, Usuario usuario, Status status) {
		this.descricao = descricao;
		this.autor = usuario;
		this.status = status;
	}
}
