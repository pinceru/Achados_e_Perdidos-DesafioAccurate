package accurate.desafio2022.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Localizacao;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.repository.ItemRepository;
import accurate.desafio2022.repository.LocalizacaoRepository;
import accurate.desafio2022.repository.StatusRepository;

@Service
public class ItemService {
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	public Status getStatus(String status) {
		return statusRepository.findByNome(status);
	}
	
	public Item salvarItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Optional<Item> getItem(Long id) {
		return itemRepository.findById(id);
	}
	
	public Localizacao salvarLocalizacao(BigDecimal latitude, BigDecimal longitude) {
		return localizacaoRepository.save(new Localizacao(latitude, longitude));
	}
	
	public Page<Item> paginarItens(Pageable paginacao) {
		return itemRepository.findAll(paginacao);
	}
}
