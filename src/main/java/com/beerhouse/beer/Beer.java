package com.beerhouse.beer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

/**
 * Modelo com atributos das Cervejas Artesanais.
 * 
 * @author Matheus R. Torres
 * @version 1.0.0
 * 
 */
@Entity
@ApiModel(description = "Modelo com atributos das Cervejas Artesanais.")
public class Beer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",nullable=false)
	private Long id;

	private String name;

	private String ingredients;

	private String alcoholContent;

	private Number price;

	private String category;

    /**
     *  Construtor vazio.
     */
	protected Beer(){}
    
	/**
	 *  Construtor com parâmetros.
	 *  
	 * @param id Id da Cerveja Artesanal.
	 * @param name Nome da Cerveja Artesanal.
	 * @param ingredients Ingredientes da Cerveja Artesanal.
	 * @param alcoholContent Conteúdo Alcoólico da Cerveja Artesanal.
	 * @param price Preço da Cerveja Artesanal.
	 * @param category Categoria da Cerveja Artesanal.
	 */
	public Beer(Long id, String name, String ingredients,
			String alcoholContent, double price, String category) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.alcoholContent = alcoholContent;
		this.price = price;
		this.category = category;
	}

	/**
	 * Recupera Id da Cerveja Artesanal.
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Define o Id da Cerveja Artesanal.
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Recupera Nome da Cerveja Artesanal.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define o Nome da Cerveja Artesanal
	 * 
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Recupera os Ingredientes da Cerveja Artesanal.
	 * 
	 * @return ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}

	/**
	 * Define os Ingredientes da Cerveja Artesanal.
	 * 
	 * @param ingredients
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * Recupera o Conteúdo Alcoólico da Cerveja Artesanal.
	 * 
	 * @return alcoholContent
	 */
	public String getAlcoholContent() {
		return alcoholContent;
	}

	/**
	 * Define o Conteúdo Alcoólico da Cerveja Artesanal.
	 * 
	 * @param alcoholContent
	 */
	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	/**
	 * Recupera o Preço da Cerveja Artesanal.
	 * 
	 * @return price
	 */
	public Number getPrice() {
		return price;
	}

	/**
	 * Define o Preço da Cerveja Artesanal.
	 * 
	 * @param price
	 */
	public void setPrice(Number price) {
		this.price = price;
	}

	/**
	 * Define a Categoria da Cerveja Artesanal.
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Define a Categoria da Cerveja Artesanal.
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", ingredients="
				+ ingredients + ", alcoholContent=" + alcoholContent
				+ ", price=" + price + ", category=" + category + "]";
	}		
}
