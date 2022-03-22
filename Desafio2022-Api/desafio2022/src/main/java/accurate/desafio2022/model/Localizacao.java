package accurate.desafio2022.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Localizacao {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public Localizacao() {
		
	}
	
	public Localizacao(BigDecimal latitude, BigDecimal longitude) {
		this.latitude = latitude;	
		this.longitude = longitude;
	}
}
