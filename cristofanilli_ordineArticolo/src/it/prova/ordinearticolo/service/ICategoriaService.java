package it.prova.ordinearticolo.service;

import java.util.List;

import it.prova.ordinearticolo.dao.IArticoloDAO;
import it.prova.ordinearticolo.dao.ICategoriaDAO;
import it.prova.ordinearticolo.model.Articolo;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface ICategoriaService {
	
	// per injection
		public void setCategoriaDAO(ICategoriaDAO categoriaDAO);
		public void setArticoloDAO(IArticoloDAO articoloDAO);

		
		public List<Categoria> listAll() throws Exception;

		public Categoria caricaSingoloElemento(Long id) throws Exception;

		public void aggiorna(Categoria categoriaInstance) throws Exception;

		public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

		public void rimuovi(Categoria categoriaInstance) throws Exception;
		
		//disassocia
		public void disassociaCategoriaArticolo(Categoria categoriaInstance,Articolo articoloEsistente) throws Exception;

		//tutte le categorie degli articoli di un determinato ordine
		public List<Categoria> tutteCategorieDegliArticoliDiUnOridine(Ordine ordineInstance) throws Exception;

}
