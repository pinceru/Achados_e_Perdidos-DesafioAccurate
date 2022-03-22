package accurate.desafio2022.config.validacao;

import lombok.Data;

@Data
public class ErroFormularioDTO {
	private String nomeCampo;
	private String erro;
	
	public ErroFormularioDTO(String nomeCampo, String erro) {
		this.nomeCampo = nomeCampo;
		this.erro = erro;
	}
}
