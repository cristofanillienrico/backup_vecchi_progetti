package it.prova.gestionegalleria.service;

import java.util.List;

import it.prova.gestionegalleria.dao.ITintaDAO;
import it.prova.gestionegalleria.model.Tinta;

public interface ITintaService {

	public void setTintaDAO(ITintaDAO tintaDAO);

	public List<Tinta> listAll() throws Exception;

	public Tinta caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Tinta tintaInstance) throws Exception;

	public void inserisciNuovo(Tinta tintaInstance) throws Exception;

	public void rimuovi(Tinta tintaInstance) throws Exception;

}
