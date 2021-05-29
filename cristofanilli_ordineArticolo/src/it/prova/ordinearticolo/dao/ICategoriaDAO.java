package it.prova.ordinearticolo.dao;

import java.util.List;

import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface ICategoriaDAO extends IBaseDAO<Categoria> {
	
	public List<Categoria> allCategorieOfArticoliOfOridine(Ordine ordineInstance) throws Exception;


}
