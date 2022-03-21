package accurate.desafio2022.model;

import java.time.LocalDateTime;
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
	private LocalDateTime data = LocalDateTime.now();
	@ManyToOne
	private Usuario autor;
	@OneToMany(mappedBy = "item")
	private List<ItemStatus> itemStatus;
}
