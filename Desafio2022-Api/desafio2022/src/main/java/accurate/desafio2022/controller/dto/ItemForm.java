package accurate.desafio2022.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import accurate.desafio2022.config.FormatarData;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Localizacao;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.repository.LocalizacaoRepository;
import accurate.desafio2022.repository.StatusRepository;
import accurate.desafio2022.repository.UsuarioRepository;
import accurate.desafio2022.service.ItemService;
import accurate.desafio2022.service.UsuarioService;
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
	
	public Item converter(UsuarioRepository usuarioRepository, StatusRepository statusRepository, 
			LocalizacaoRepository localizacaoRepository, ItemService service) {

		UsuarioService usuarioService = new UsuarioService();
		Status statusObj = service.getStatus(statusRepository, status);
		Localizacao localizacao = localizacaoRepository.save(new Localizacao(latitude, longitude));
		Usuario usuario = usuarioService.getUsuario(usuarioRepository, nome, telefone);
		LocalDateTime dataFormatada = FormatarData.formatarData(data);
		return new Item(descricao, usuario, statusObj, dataFormatada, localizacao);
	}

	
}
