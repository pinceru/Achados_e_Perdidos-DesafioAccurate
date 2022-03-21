package accurate.desafio2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accurate.desafio2022.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
