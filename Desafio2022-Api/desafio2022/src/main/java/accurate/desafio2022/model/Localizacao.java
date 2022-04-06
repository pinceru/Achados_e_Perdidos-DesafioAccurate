package accurate.desafio2022.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Localizacao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal latitude;
	private BigDecimal longitude;
	@OneToMany(mappedBy = "localizacao")
	private List<Item> item;
	
	public Localizacao() {
		
	}
	
	public Localizacao(BigDecimal latitude, BigDecimal longitude) {
		this.latitude = latitude;	
		this.longitude = longitude;
	}
}
