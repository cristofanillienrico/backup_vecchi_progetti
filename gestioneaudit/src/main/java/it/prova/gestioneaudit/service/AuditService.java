package it.prova.gestioneaudit.service;

import java.util.List;

import it.prova.gestioneaudit.dao.AuditDAO;
import it.prova.gestioneaudit.model.Audit;
import it.prova.gestioneaudit.model.Ruolo;

public interface AuditService {

	public List<Audit> listAll() throws Exception;

	public Audit caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Audit auditInstance) throws Exception;

	public void inserisciNuovo(Audit auditInstance) throws Exception;

	public void rimuovi(Audit auditInstance) throws Exception;

	// per injection
	public void setAuditDAO(AuditDAO auditDAO);

	// metodi aggiuntivi
	public List<Audit> tuttiAssociatiAQuelRuolo(Ruolo ruolo) throws Exception;

}
