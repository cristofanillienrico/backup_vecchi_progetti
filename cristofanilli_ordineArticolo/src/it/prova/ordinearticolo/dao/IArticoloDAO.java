package it.prova.ordinearticolo.dao;

import java.util.List;

import it.prova.ordinearticolo.model.Articolo;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface IArticoloDAO extends IBaseDAO<Articolo> {

	public List<Articolo> findAllByOrdine(Ordine ordineInstance) throws Exception;
	
	public Double sumPriceArticoliLinkToCategoria(Categoria categoriaInstance) throws Exception;


}
