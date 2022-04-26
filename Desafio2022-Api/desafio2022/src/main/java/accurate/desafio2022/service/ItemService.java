package accurate.desafio2022.service;

import accurate.desafio2022.model.Status;
import accurate.desafio2022.repository.StatusRepository;

public class ItemService {

	public Status getStatus(StatusRepository statusRepository, String status) {
		return statusRepository.findByNome(status);
	}
}
