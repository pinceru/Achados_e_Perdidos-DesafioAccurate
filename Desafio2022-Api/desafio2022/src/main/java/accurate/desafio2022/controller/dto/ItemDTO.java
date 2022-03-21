package accurate.desafio2022.controller.dto;

import accurate.desafio2022.model.Item;
import lombok.Data;

@Data
public class ItemDTO {
	
	private Long id;
	private String nome;
	private String telefone;
	private String descricao;
	
	public ItemDTO(Item item) {
		this.id = item.getId();
		this.nome = item.getAutor().getNome();
		this.telefone = item.getAutor().getTelefone();
		this.descricao = item.getDescricao();
		
	}
}
