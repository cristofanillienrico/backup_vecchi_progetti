package it.prova.negozioreparto.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.negozioreparto.dao.EntityManagerUtil;
import it.prova.negozioreparto.dao.IRepartoDAO;
import it.prova.negozioreparto.model.Addetto;
import it.prova.negozioreparto.model.Reparto;

public class RepartoServiceImpl implements IRepartoService {

	private IRepartoDAO repartoDAO;

	@Override
	public void setRepartoDAO(IRepartoDAO repartoDAO) {
		this.repartoDAO = repartoDAO;

	}

	@Override
	public List<Reparto> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return repartoDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Reparto caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return repartoDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Reparto repartoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			repartoDAO.update(repartoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void inserisciNuovo(Reparto repartoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			repartoDAO.insert(repartoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void rimuovi(Reparto repartoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate il reparto
			repartoInstance = entityManager.merge(repartoInstance);

			// dissocio le categorie
			repartoInstance.getAddetti().clear();

			// eseguo quello che realmente devo fare
			repartoDAO.delete(repartoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void aggiungiAddetto(Reparto repartoInstance, Addetto addettoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			repartoDAO.setEntityManager(entityManager);

			// faccio merge
			repartoInstance = entityManager.merge(repartoInstance);
			addettoInstance = entityManager.merge(addettoInstance);

			// aggiungo addetto al reparto
			repartoInstance.getAddetti().add(addettoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

}
