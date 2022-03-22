package accurate.desafio2022.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import accurate.desafio2022.controller.dto.AtualizarItemDTO;
import accurate.desafio2022.controller.dto.InserirItemDTO;
import accurate.desafio2022.controller.dto.ItemDTO;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.ItemRepository;
import accurate.desafio2022.repository.LocalizacaoRepository;
import accurate.desafio2022.repository.StatusRepository;
import accurate.desafio2022.repository.UsuarioRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<ItemDTO> cadastrarItem(@RequestBody @Valid InserirItemDTO insercaoDTO, 
														UriComponentsBuilder uriBuilder) {
		
		Item item = insercaoDTO.converter(usuarioRepository, statusRepository, localizacaoRepository);
		itemRepository.save(item);
		
		URI uri = uriBuilder.path("/item/{id}")
				.buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemDTO(item));
	}
	
	@GetMapping("/listar")
	@Transactional
	public Page<ItemDTO> listarTodos(@PageableDefault(sort = "data", 
										direction = Direction.ASC, page = 0, size = 10) 
										Pageable paginacao) {
		
		Page<Item> itens = itemRepository.findAll(paginacao);
		return ItemDTO.converter(itens);
	}
	
	@GetMapping("/buscar/{id}")
	@Transactional
	public ResponseEntity<ItemDTO> buscarItem(@PathVariable Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			return ResponseEntity.ok(new ItemDTO(item.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<ItemDTO> atualizarItem(@PathVariable @Valid Long id, 
													@RequestBody AtualizarItemDTO atualizarDTO) {
		
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			Item itemAtualizado = atualizarDTO.atualizarItem(id, itemRepository);
			return ResponseEntity.ok(new ItemDTO(itemAtualizado));
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletarItem(@PathVariable Long id) {
		Optional<Item> item = itemRepository.findById(id);
		if(item.isPresent()) {
			itemRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
