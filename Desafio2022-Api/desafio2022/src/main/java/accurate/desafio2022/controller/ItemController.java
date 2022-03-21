package accurate.desafio2022.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import accurate.desafio2022.controller.dto.ItemDTO;

@RestController
@RequestMapping("/item")
public class ItemController {
	public ResponseEntity<ItemDTO> cadastrarItem(@RequestBody InserirItemDTO insercaoDTO, 
														UriComponentsBuilder uriBuilder) {
		
	}
}
