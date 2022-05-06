package accurate.desafio2022.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import accurate.desafio2022.model.Historico;
import accurate.desafio2022.model.Item;
import accurate.desafio2022.repository.HistoricoRepository;

@Service
public class HistoricoService {
	
	@Autowired
	private HistoricoRepository historicoRepository;
	
	public void salvarHistorico(Historico historico) {
		historicoRepository.save(historico);
	}
	
	public Historico gerarNovoHistorico(Item item) {
		return new Historico(item, item.getStatus().getNome(), item.getDescricao(), item.getData());
	}
	
	public Page<Historico> buscarHistorico(Item item, Pageable paginacao) {
		return historicoRepository.findByItem(item, paginacao);
	}
}
