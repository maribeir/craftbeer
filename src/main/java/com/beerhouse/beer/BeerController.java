package com.beerhouse.beer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller com os serviços disponibilizados pela API para operações com as Cervejas Artesanais.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@RestController
@RequestMapping("/beers")
public class BeerController {	

	@Autowired
	private BeerRepository beerService;

	/**
	 * Consulta todas as Cervejas Artesanais cadastradas.
	 * 
	 * @return ResponseEntity<List<Beer>>
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Beer>> findAll(){		
		List<Beer> beers = (List<Beer>) beerService.findAll();		
		return new ResponseEntity<>(beers, HttpStatus.OK);
	}

	/**
	 * Consulta uma Cerveja Artesanal pelo id.
	 * 
	 * @param id Id da Cerveja Artesanal a ser consultada.
	 * @return ResponseEntity<Beer>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Beer> findById(@PathVariable String id){		
		Beer beer = beerService.findOne(Long.valueOf(id));		
		return new ResponseEntity<>(beer, HttpStatus.OK);
	}

	/**
	 * Insere uma nova Cerveja Artesanal.
	 * 
	 * @param body Bean Beer com dados da Cerveja Artesanal a ser inserida.
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Void> createBeer(@RequestBody Beer body){		
		beerService.save(body);		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Altera uma Cerveja Artesanal já cadastrada.
	 * 
	 * @param id Id da Cerveja Artesanal a ser alterada.
	 * @param beer Bean Beer com dados da Cerveja Artesanal a ser inserida.
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Void> updateBeer(@PathVariable String id, @RequestBody Beer beer){		
		beer.setId(Long.valueOf(id));
		beerService.save(beer);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Exclui uma Cerveja Artesanal.
	 * 
	 * @param id Id da Cerveja Artesanal a ser excluída.
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> deleteBeer(@PathVariable String id){		
		beerService.delete(Long.valueOf(id));
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
