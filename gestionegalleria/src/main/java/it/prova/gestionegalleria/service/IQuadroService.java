package it.prova.gestionegalleria.service;

import java.util.List;

import it.prova.gestionegalleria.dao.IQuadroDAO;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;
import it.prova.gestionegalleria.model.Tinta;

public interface IQuadroService {
	public void setQuadroDAO(IQuadroDAO quadroDAO);

	public List<Quadro> listAll() throws Exception;

	public Quadro caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Quadro quadroInstance) throws Exception;

	public void inserisciNuovo(Quadro quadroInstance) throws Exception;

	public void rimuovi(Quadro quadroInstance) throws Exception;

	// accessori
	public void aggiungiTinta(Quadro quadroInstance, Tinta tintaInstance) throws Exception;

	public void aggiungiRestauratore(Quadro quadroInstance, Restauratore restauratoreInstance) throws Exception;

}
