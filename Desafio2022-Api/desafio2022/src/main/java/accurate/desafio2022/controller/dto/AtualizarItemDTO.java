package accurate.desafio2022.controller.dto;

import java.time.LocalDateTime;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.ItemRepository;
import lombok.Data;

@Data
public class AtualizarItemDTO {
	private String nome;
	private String telefone;
	private String descricao;
	private String status;
	private String data;
	
	public Item atualizarItem(Long id, ItemRepository itemRepository) {
		Item item = itemRepository.getOne(id);
		item.getAutor().setNome(this.nome);
		item.getAutor().setTelefone(this.telefone);
		item.setDescricao(this.descricao);
		item.getStatus().setNome(this.status);
		item.setData(LocalDateTime.parse(this.data));
		return item;
	}

}
