package accurate.desafio2022.service;

import java.util.Optional;

import accurate.desafio2022.model.Item;
import accurate.desafio2022.model.Status;
import accurate.desafio2022.repository.ItemRepository;
import accurate.desafio2022.repository.StatusRepository;

public class ItemService {

	public Status getStatus(StatusRepository statusRepository, String status) {
		return statusRepository.findByNome(status);
	}
	
	public Item salvarItem(ItemRepository repository, Item item) {
		return repository.save(item);
	}
	
	public Optional<Item> getItem(ItemRepository repository, Long id) {
		return repository.findById(id);
	}
}
