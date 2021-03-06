package accurate.desafio2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accurate.desafio2022.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

	Status findByNome(String nome);

}
