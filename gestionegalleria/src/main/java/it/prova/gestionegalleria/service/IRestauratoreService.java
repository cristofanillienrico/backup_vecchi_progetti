package it.prova.gestionegalleria.service;

import java.util.List;

import it.prova.gestionegalleria.dao.IRestauratoreDAO;
import it.prova.gestionegalleria.model.Restauratore;

public interface IRestauratoreService {

	public void setRestauratoreDAO(IRestauratoreDAO restauratoreDAO);

	public List<Restauratore> listAll() throws Exception;

	public Restauratore caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Restauratore restauratoreInstance) throws Exception;

	public void inserisciNuovo(Restauratore restauratoreInstance) throws Exception;

	public void rimuovi(Restauratore restauratoreInstance) throws Exception;

}
