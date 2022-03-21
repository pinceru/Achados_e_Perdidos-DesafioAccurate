package accurate.desafio2022.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy = "item")
	private List<ItemStatus> itemStatus;
	
	public Item(String descricao, Usuario usuario) {
		this.descricao = descricao;
		this.autor = usuario;
	}
}
