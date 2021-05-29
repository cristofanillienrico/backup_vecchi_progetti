package it.prova.gestioneaudit.service;

import java.util.List;

import it.prova.gestioneaudit.dao.RuoloDAO;
import it.prova.gestioneaudit.dao.UtenteDAO;
import it.prova.gestioneaudit.model.CodiceEsitoOperazione;
import it.prova.gestioneaudit.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll() throws Exception;

	public Ruolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ruolo ruoloInstance) throws Exception;

	public void inserisciNuovo(Ruolo ruoloInstance) throws Exception;

	public void rimuovi(Ruolo ruoloInstance) throws Exception;

	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception;

	// per injection
	public void setRuoloDAO(RuoloDAO ruoloDAO);

	public void setUtenteDAO(UtenteDAO utenteDAO);

	// metodi aggiuntivi

	public List<Ruolo> tuttiRuoliDiUtentiAssociatiACodiceEsitoOperazione(CodiceEsitoOperazione input) throws Exception;

	public List<String> tutteLePasswordUtentiAssociatiAUnRuolo(Ruolo ruolo) throws Exception;

}
