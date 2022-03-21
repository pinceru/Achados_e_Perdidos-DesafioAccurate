package accurate.desafio2022.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ItemStatus {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Status status;
	@ManyToOne
	private Item item;
	
	public ItemStatus() {
		
	}
	
	public ItemStatus(Item item, Status status) {
		this.item = item;
		this.status = status;
	}
}
