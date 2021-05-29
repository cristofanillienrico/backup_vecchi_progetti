package it.prova.gestioneaudit.dao;

import java.util.List;

import it.prova.gestioneaudit.model.CodiceEsitoOperazione;
import it.prova.gestioneaudit.model.Ruolo;

public interface RuoloDAO extends IBaseDAO<Ruolo> {

	public Ruolo findByDescrizioneAndCodice(String descrizione, String codice) throws Exception;

	public List<Ruolo> allRuoliOfUtentiAssociatedAToCodiceEsitoOperazione(CodiceEsitoOperazione input) throws Exception;

	public List<String> allPasswordUtentiAssociatedToRuolo(Ruolo ruolo) throws Exception;

}
