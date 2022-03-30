package accurate.desafio2022.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accurate.desafio2022.model.Historico;
import accurate.desafio2022.model.Item;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

	Page<Historico> findByItem(Item item, Pageable paginacao);

}
