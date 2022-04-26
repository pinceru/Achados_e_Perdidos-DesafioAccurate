package accurate.desafio2022.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import accurate.desafio2022.helper.FormatarData;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Status;
import lombok.Data;

@Data
public class AtualizarItemForm {
	@NotNull @NotEmpty @Size(max = 50, min = 1)
	private String nome;
	@Size(max = 15, min = 14)
	private String telefone;
	@NotNull @NotEmpty
	private String descricao;
	private String status;
	@NotNull @NotEmpty
	private String data;
	@NotNull 
	private BigDecimal latitude;
	@NotNull
	private BigDecimal longitude;
	
	public Item atualizarItem(Item item, Status status) {
		item.getAutor().setNome(this.nome);
		item.getAutor().setTelefone(this.telefone);
		item.setDescricao(this.descricao);
		item.setStatus(status);
		item.setData(FormatarData.formatarData(this.data));
		item.getLocalizacao().setLatitude(this.latitude);
		item.getLocalizacao().setLongitude(this.longitude);
		return item;
	}
}
