package accurate.desafio2022.controller.dto;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.ItemRepository;
import lombok.Data;

@Data
public class AtualizarItemDTO {
	private String nome;
	private String telefone;
	private String descricao;
	private String status;
	
	public Item atualizarItem(Long id, ItemRepository itemRepository) {
		Item item = itemRepository.getOne(id);
		item.getAutor().setNome(this.nome);
		item.getAutor().setTelefone(this.telefone);
		item.setDescricao(this.descricao);
		item.getStatus().setStatus(this.status);
		return item;
	}

}
