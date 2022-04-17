package accurate.desafio2022.controller.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import accurate.desafio2022.config.FormatarData;
import accurate.desafio2022.model.Item;
import lombok.Data;

@Data
public class ItemDTO {
	
	private Long id;
	private String nome;
	private String telefone;
	private String descricao;
	private String status;
	private String data;
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public ItemDTO(Item item) {
		this.id = item.getId();
		this.nome = item.getAutor().getNome();
		this.telefone = item.getAutor().getTelefone();
		this.descricao = item.getDescricao();
		this.status = item.getStatus().getNome();
		this.data = FormatarData.converterData(item.getData());
		this.latitude = item.getLocalizacao().getLatitude();
		this.longitude = item.getLocalizacao().getLongitude();
	}

	public static Page<ItemDTO> converter(Page<Item> itens) {
		return itens.map(ItemDTO::new);
	}
}
