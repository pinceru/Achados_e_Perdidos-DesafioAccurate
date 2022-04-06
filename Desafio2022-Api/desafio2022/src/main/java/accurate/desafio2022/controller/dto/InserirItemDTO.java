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
import lombok.Data;

@Data
public class InserirItemDTO {
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
			LocalizacaoRepository localizacaoRepository) {
		Status statusObj = statusRepository.findByNome(status);
		Localizacao localizacao = localizacaoRepository.save(new Localizacao(latitude, longitude));
		Optional<Usuario> usuario = usuarioRepository.findByNomeAndTelefone(nome, telefone);
		LocalDateTime dataFormatada = FormatarData.formatarData(data);
		if(usuario.isPresent()) {
			return new Item(descricao, usuario.get(), statusObj, dataFormatada, localizacao);
		} else {
			Usuario novoUsuario = usuarioRepository.save(new Usuario(nome, telefone));
			return new Item(descricao, novoUsuario, statusObj, dataFormatada, localizacao);
		}
	}
}
