package accurate.desafio2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accurate.desafio2022.model.Status;

@Repository
public interface StatusRepsoitory extends JpaRepository<Status, Long>{

	Status findByStatus(String status);

}
