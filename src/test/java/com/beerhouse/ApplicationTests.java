package com.beerhouse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.beerhouse.beer.Beer;
import com.beerhouse.beer.BeerController;
import com.beerhouse.beer.BeerRepository;

/**
 * Classe de Teste do Swagger.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BeerRepository beerRepository;

	Beer mockBeer = new Beer(new Long(1), "Eisenbahn", "Trigo", "5", 4.0, "Weiss");
    
	@Test
	public void contextLoads() throws Exception {

		Mockito.when(beerRepository.findOne(Mockito.anyLong())).thenReturn(mockBeer);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/beers/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"id\":1,\"name\":\"Eisenbahn\",\"ingredients\":\"Trigo\",\"alcoholContent\":\"5\",\"price\":4.0,\"category\":\"Weiss\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}