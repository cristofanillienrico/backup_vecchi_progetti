package it.prova.gestioneaudit.dao;

import java.util.List;

import it.prova.gestioneaudit.model.Audit;
import it.prova.gestioneaudit.model.Ruolo;
import it.prova.gestioneaudit.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public List<Utente> findAllByRuolo(Ruolo ruoloInput) throws Exception;

	public List<Audit> findAllByUtente(Utente utenteInstance) throws Exception;;

}
