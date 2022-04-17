package accurate.desafio2022.controller.dto;

import org.springframework.data.domain.Page;

import accurate.desafio2022.config.FormatarData;
import accurate.desafio2022.model.Historico;
import lombok.Data;

@Data
public class HistoricoDTO {
	private Long id;
	private String status;
	private String descricao;
	private String data;
	
	public HistoricoDTO(Historico historico) {
		this.id = historico.getId();
		this.status = historico.getStatus();
		this.descricao = historico.getDescricao();
		this.data = FormatarData.converterData(historico.getData());
	}
	
	public static Page<HistoricoDTO> converter(Page<Historico> historico) {
		return historico.map(HistoricoDTO::new);
	}
}
