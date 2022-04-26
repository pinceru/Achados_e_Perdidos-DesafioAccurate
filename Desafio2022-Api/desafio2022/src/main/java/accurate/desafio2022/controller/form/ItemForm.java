package accurate.desafio2022.controller.form;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import accurate.desafio2022.helper.FormatarData;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Localizacao;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.model.Usuario;
import lombok.Data;

@Data
public class ItemForm {
	@NotNull @NotEmpty @Size(max = 50, min = 1)
	private String nome;
	@Size(max = 15, min = 14)
	private String telefone;
	@NotNull @NotEmpty
	private String descricao;
	private String status;
	@NotNull @NotEmpty
	private String data;
	@NotNull @Max(90)  @Min(-90) 
	private BigDecimal latitude;
	@NotNull @Max(180)  @Min(-180)
	private BigDecimal longitude;
	
	public Item converter(Usuario usuario, Status status, Localizacao localizacao) {
		LocalDateTime dataFormatada = FormatarData.formatarData(data);
		return new Item(descricao, usuario, status, dataFormatada, localizacao);
	}
}
