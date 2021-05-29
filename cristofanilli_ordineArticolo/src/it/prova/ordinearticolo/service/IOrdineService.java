package it.prova.ordinearticolo.service;

import java.util.List;

import it.prova.ordinearticolo.dao.IArticoloDAO;
import it.prova.ordinearticolo.dao.IOrdineDAO;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface IOrdineService {

	// per injection
	public void setOrdineDAO(IOrdineDAO ordineDAO);

	public void setArticoloDAO(IArticoloDAO articoloDAO);

	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	// METODI RICHIESTI

	// tutti gli ordini effettuati data una determinata categoria
	public List<Ordine> tuttiOrdiniDataUnaCategoria(Categoria categoriaInstance) throws Exception;

}
