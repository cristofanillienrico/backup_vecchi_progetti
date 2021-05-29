package it.prova.negozioreparto.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.negozioreparto.dao.EntityManagerUtil;
import it.prova.negozioreparto.dao.INegozioDAO;
import it.prova.negozioreparto.model.Negozio;
import it.prova.negozioreparto.model.Reparto;

public class NegozioServiceImpl implements INegozioService {

	private INegozioDAO negozioDAO;

	@Override
	public void setNegozioDAO(INegozioDAO negozioDAO) {
		this.negozioDAO = negozioDAO;

	}

	@Override
	public List<Negozio> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return negozioDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Negozio caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return negozioDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			negozioDAO.update(negozioInstance);

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
	public void inserisciNuovo(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			negozioDAO.insert(negozioInstance);

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
	public void rimuovi(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// non posso cancellare negozi se hanno associati dei reparti
			if (!negozioDAO.allRepartiByNegozio(negozioInstance).isEmpty()) {
				throw new Exception("Non posso cancellare il Negozio finchè ci sono reparti attivi");
			}

			// eseguo quello che realmente devo fare
			negozioDAO.delete(negozioInstance);

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
	public List<Reparto> tuttiRepartiDatoUnNegozio(Negozio negozioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return negozioDAO.allRepartiByNegozio(negozioInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Negozio> listaNegoziConAddettoConDeterminatoCognome(String cognome) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			negozioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return negozioDAO.listNegoziWithAddettoWithCognome(cognome);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
