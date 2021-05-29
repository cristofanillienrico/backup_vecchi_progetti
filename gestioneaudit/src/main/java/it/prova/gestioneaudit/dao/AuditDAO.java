package it.prova.gestioneaudit.dao;

import java.util.List;

import it.prova.gestioneaudit.model.Audit;
import it.prova.gestioneaudit.model.Ruolo;

public interface AuditDAO extends IBaseDAO<Audit> {

	public List<Audit> allAssociatedToThisRuolo(Ruolo ruolo) throws Exception;

}
