package accurate.desafio2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accurate.desafio2022.model.ItemStatus;

@Repository
public interface ItemStatusRepository extends JpaRepository<ItemStatus, Long> {
	
}
