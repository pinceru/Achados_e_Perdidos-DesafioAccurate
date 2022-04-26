package accurate.desafio2022.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import accurate.desafio2022.model.Historico;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.HistoricoRepository;

public class HistoricoService {
	public void salvarHistorico(Historico historico, HistoricoRepository historicoRepository) {
		historicoRepository.save(historico);
	}
	
	public Historico gerarNovoHistorico(Item item) {
		return new Historico(item, item.getStatus().getNome(), item.getDescricao(), item.getData());
	}
	
	public Page<Historico> buscarHistorico(Item item, Pageable paginacao, HistoricoRepository repository) {
		return repository.findByItem(item, paginacao);
	}
}
