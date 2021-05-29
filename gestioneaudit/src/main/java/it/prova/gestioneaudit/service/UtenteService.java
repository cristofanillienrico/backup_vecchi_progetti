package it.prova.gestioneaudit.service;

import java.util.List;

import it.prova.gestioneaudit.dao.UtenteDAO;
import it.prova.gestioneaudit.model.Ruolo;
import it.prova.gestioneaudit.model.Utente;

public interface UtenteService {

	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;

	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;

	// per injection
	public void setUtenteDAO(UtenteDAO utenteDAO);

	// metodi richiesti
	public void disaccoppiaUtenteRuolo(Utente utente, Ruolo ruolo) throws Exception;

}
