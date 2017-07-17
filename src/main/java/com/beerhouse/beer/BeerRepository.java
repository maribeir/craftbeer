package com.beerhouse.beer;

import org.springframework.data.repository.CrudRepository;

/**
 * Classe de repositório, que herda os recursos de persistência 
 * da classe CrudRepository do Spring, para a tabela Beer.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
public interface BeerRepository extends CrudRepository<Beer, Long> {
	
}
