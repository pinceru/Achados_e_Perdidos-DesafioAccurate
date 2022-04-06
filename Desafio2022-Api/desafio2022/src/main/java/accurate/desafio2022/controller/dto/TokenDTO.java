package accurate.desafio2022.controller.dto;

import lombok.Data;

@Data
public class TokenDTO {

	private String token;
	private String tipo;
	
	public TokenDTO(String token, String tipo) {
		this.tipo = tipo;
		this.token = token;
	}

}
