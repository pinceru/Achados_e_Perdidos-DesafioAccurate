package accurate.desafio2022.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Status {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;
	@OneToMany(mappedBy = "status")
	private List<ItemStatus> itemStatus;
}
