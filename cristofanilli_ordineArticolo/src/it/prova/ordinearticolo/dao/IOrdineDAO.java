package it.prova.ordinearticolo.dao;

import java.util.List;

import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface IOrdineDAO extends IBaseDAO<Ordine> {
	
	public List<Ordine> allOrdiniByCategoria(Categoria categoriaInstance) throws Exception;


}
