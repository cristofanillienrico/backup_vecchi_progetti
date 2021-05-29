package it.prova.negozioreparto.service;

import java.util.List;

import it.prova.negozioreparto.dao.IRepartoDAO;
import it.prova.negozioreparto.model.Addetto;
import it.prova.negozioreparto.model.Reparto;

public interface IRepartoService {

	public void setRepartoDAO(IRepartoDAO repartoDAO);

	public List<Reparto> listAll() throws Exception;

	public Reparto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Reparto repartoInstance) throws Exception;

	public void inserisciNuovo(Reparto repartoInstance) throws Exception;

	public void rimuovi(Reparto repartoInstance) throws Exception;

	// accessori
	public void aggiungiAddetto(Reparto repartoInstance, Addetto addettoInstance) throws Exception;

}
