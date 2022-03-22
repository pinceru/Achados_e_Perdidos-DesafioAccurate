package accurate.desafio2022.controller.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	public Item converter(UsuarioRepository usuarioRepository, StatusRepository statusRepository, 
			LocalizacaoRepository localizacaoRepository) {
		Status statusObj = statusRepository.findByNome(status);
		Localizacao localizacao = localizacaoRepository.save(new Localizacao(latitude, longitude));
		Optional<Usuario> usuario = usuarioRepository.findByNome(nome);
		LocalDateTime dataFormatada = FormatarData.formatarData(data);
		if(usuario.isPresent()) {
			return new Item(descricao, usuario.get(), statusObj, dataFormatada, localizacao);
		} else {
			Usuario novoUsuario = usuarioRepository.save(new Usuario(nome, telefone));
			return new Item(descricao, novoUsuario, statusObj, dataFormatada, localizacao);
		}
	}
}
