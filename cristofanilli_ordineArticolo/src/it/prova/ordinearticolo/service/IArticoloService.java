package it.prova.ordinearticolo.service;

import java.util.List;

import it.prova.ordinearticolo.dao.IArticoloDAO;
import it.prova.ordinearticolo.model.Articolo;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public interface IArticoloService {

	// per injection
	public void setArticoloDAO(IArticoloDAO articoloDAO);

	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	public List<Articolo> trovaTuttiDaOrdine(Ordine ordineInstance) throws Exception;

	// associare a dissociare
	public void aggiungiCategoria(Articolo articoloEsistente, Categoria categoriaInstance) throws Exception;

	public void disassociaArticoloCategoria(Articolo articoloEsistente, Categoria categoriaInstance) throws Exception;

	// somma totale di tutti i prezzi degli articoli legati ad una categoria
	public Double sommaPrezziArticoliDiUnaCategoria(Categoria categoriaInstance) throws Exception;

}
