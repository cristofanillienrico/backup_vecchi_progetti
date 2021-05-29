package it.prova.negozioreparto.service;

import java.util.List;

import it.prova.negozioreparto.dao.IAddettoDAO;
import it.prova.negozioreparto.model.Addetto;

public interface IAddettoService {

	public void setAddettoDAO(IAddettoDAO addettoDAO);

	public List<Addetto> listAll() throws Exception;

	public Addetto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Addetto addettoInstance) throws Exception;

	public void inserisciNuovo(Addetto addettoInstance) throws Exception;

	public void rimuovi(Addetto addettoInstance) throws Exception;

}
