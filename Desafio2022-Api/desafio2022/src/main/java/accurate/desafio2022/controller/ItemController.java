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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import accurate.desafio2022.controller.dto.HistoricoDTO;
import accurate.desafio2022.controller.dto.ItemDTO;
import accurate.desafio2022.controller.form.AtualizarItemForm;
import accurate.desafio2022.controller.form.ItemForm;
import accurate.desafio2022.model.Historico;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Localizacao;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.model.Usuario;
import accurate.desafio2022.service.HistoricoService;
import accurate.desafio2022.service.ItemService;
import accurate.desafio2022.service.UsuarioService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HistoricoService historicoService;
	
	@PostMapping("/")
	public ResponseEntity<ItemDTO> cadastrarItem(@RequestBody @Valid ItemForm itemForm, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = usuarioService.getUsuario(itemForm.getNome(), itemForm.getTelefone());
		Status status = itemService.getStatus(itemForm.getStatus());
		Localizacao localizacao = itemService.salvarLocalizacao(itemForm.getLatitude(), itemForm.getLongitude());
		
		Item item = itemForm.converter(usuario, status, localizacao);
		Item itemSalvo = itemService.salvarItem(item);
		Historico historico = historicoService.gerarNovoHistorico(itemSalvo);
		historicoService.salvarHistorico(historico);
		
		URI uri = uriBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).body(new ItemDTO(item));
	}
	
	@GetMapping("/")
	@Transactional
	public Page<ItemDTO> listarTodos(@PageableDefault(sort = "data", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Item> itens = itemService.paginarItens(paginacao);
		return ItemDTO.converter(itens);
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<ItemDTO> buscarItem(@PathVariable Long id) {
		Optional<Item> item = itemService.getItem(id);
		if(item.isPresent()) {
			return ResponseEntity.ok(new ItemDTO(item.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ItemDTO> atualizarItem(@PathVariable @Valid Long id, @RequestBody AtualizarItemForm itemForm) {
		
		Optional<Item> item = itemService.getItem(id);
		if(item.isPresent()) {
			Status status = itemService.getStatus(itemForm.getStatus());
			Item itemAtualizado = itemForm.atualizarItem(item.get(), status);
			Item itemSalvo = itemService.salvarItem(itemAtualizado);
			Historico historico = historicoService.gerarNovoHistorico(itemAtualizado);
			historicoService.salvarHistorico(historico);
			return ResponseEntity.ok(new ItemDTO(itemSalvo));
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@GetMapping("/historico/{id}")
	@Transactional
	public Page<HistoricoDTO> listarHistorico(@PathVariable Long id, @PageableDefault(sort = "data", direction = Direction.ASC, page = 0, size = 5) Pageable paginacao) {
		
		Optional<Item> item = itemService.getItem(id);
		Page<Historico> historico = historicoService.buscarHistorico(item.get(), paginacao);
		return HistoricoDTO.converter(historico);
	}
}
