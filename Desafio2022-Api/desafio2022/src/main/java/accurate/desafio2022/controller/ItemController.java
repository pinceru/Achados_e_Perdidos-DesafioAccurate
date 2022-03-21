package accurate.desafio2022.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import accurate.desafio2022.controller.dto.InserirItemDTO;
import accurate.desafio2022.controller.dto.ItemDTO;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.ItemStatus;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.repository.ItemRepository;
import accurate.desafio2022.repository.ItemStatusRepository;
import accurate.desafio2022.repository.StatusRepsoitory;
import accurate.desafio2022.repository.UsuarioRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private StatusRepsoitory statusRepository;
	
	@Autowired
	private ItemStatusRepository itemStatusRepository;
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<ItemDTO> cadastrarItem(@RequestBody InserirItemDTO insercaoDTO, 
														UriComponentsBuilder uriBuilder) {
		
		Item item = insercaoDTO.converter(usuarioRepository);
		Item itemSalvo = itemRepository.save(item);
		Status status = statusRepository.findByStatus(insercaoDTO.getStatus());
		itemStatusRepository.save(new ItemStatus(itemSalvo, status));
		
		URI uri = uriBuilder.path("/item/{id}")
				.buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemDTO(item));
	}
}
