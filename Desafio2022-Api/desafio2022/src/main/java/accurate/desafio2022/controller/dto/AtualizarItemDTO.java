package accurate.desafio2022.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import accurate.desafio2022.config.FormatarData;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.ItemRepository;
import lombok.Data;

@Data
public class AtualizarItemDTO {
	@NotNull @NotEmpty
	private String nome;
	private String telefone;
	@NotNull @NotEmpty
	private String descricao;
	private String status;
	@NotNull @NotEmpty
	private String data;
	@NotNull 
	private double latitude;
	@NotNull
	private double longitude;
	
	public Item atualizarItem(Long id, ItemRepository itemRepository) {
		Item item = itemRepository.getOne(id);
		item.getAutor().setNome(this.nome);
		item.getAutor().setTelefone(this.telefone);
		item.setDescricao(this.descricao);
		item.getStatus().setNome(this.status);
		item.setData(FormatarData.formatarData(this.data));
		item.getLocalizacao().setLatitude(this.latitude);
		item.getLocalizacao().setLongitude(this.longitude);
		return item;
	}
}
