package accurate.desafio2022.model;

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
	private double latitude;
	private double longitude;
	
	public Localizacao() {
		
	}
	
	public Localizacao(double latitude, double longitude) {
		this.latitude = latitude;	
		this.longitude = longitude;
	}
}
