package accurate.desafio2022.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Historico {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Item item;
	private String status;
	private String descricao;
	private LocalDateTime data;
	
	public Historico() {
		
	}
	
	public Historico(Item item, String status, String descricao, LocalDateTime data) {
		this.item = item;
		this.descricao = descricao;
		this.status = status;
		this.data = data;
	}
}
