package it.prova.gestioneaudit.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneaudit.dao.AuditDAO;
import it.prova.gestioneaudit.dao.EntityManagerUtil;
import it.prova.gestioneaudit.model.Audit;
import it.prova.gestioneaudit.model.Ruolo;

public class AuditServiceImpl implements AuditService {

	private AuditDAO auditDAO;

	@Override
	public void setAuditDAO(AuditDAO auditDAO) {
		this.auditDAO = auditDAO;

	}

	@Override
	public List<Audit> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			auditDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return auditDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Audit caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			auditDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return auditDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Audit auditInstance) throws Exception {
		throw new Exception("Operazione non consentita");

	}

	@Override
	public void inserisciNuovo(Audit auditInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			auditDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			auditDAO.insert(auditInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		} // TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Audit auditInstance) throws Exception {
		throw new Exception("Operazione non consentita");

	}

	@Override
	public List<Audit> tuttiAssociatiAQuelRuolo(Ruolo ruolo) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			auditDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return auditDAO.allAssociatedToThisRuolo(ruolo);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
