package it.prova.gestionegalleria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionegalleria.dao.EntityManagerUtil;
import it.prova.gestionegalleria.dao.IRestauratoreDAO;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;

public class RestauratoreServiceImpl implements IRestauratoreService {

	private IRestauratoreDAO restauratoreDAO;

	@Override
	public void setRestauratoreDAO(IRestauratoreDAO restauratoreDAO) {
		this.restauratoreDAO = restauratoreDAO;

	}

	@Override
	public List<Restauratore> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			restauratoreDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return restauratoreDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Restauratore caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			restauratoreDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return restauratoreDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Restauratore restauratoreInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			restauratoreDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			restauratoreDAO.update(restauratoreInstance);

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
	public void inserisciNuovo(Restauratore restauratoreInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			restauratoreDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			restauratoreDAO.insert(restauratoreInstance);

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
	public void rimuovi(Restauratore restauratoreInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			restauratoreDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate il reparto
			restauratoreInstance = entityManager.merge(restauratoreInstance);

			// inserisco tutti i reparti in una lista
			List<Quadro> listaQuadri = restauratoreDAO.tuttiQuadriDaRestauratore(restauratoreInstance);

			// dissocio il dato addetto da tali reparti
			for (Quadro quadroItem : listaQuadri) {
				quadroItem.getRestauratori().remove(restauratoreInstance);

			}

			// eseguo quello che realmente devo fare
			restauratoreDAO.delete(restauratoreInstance);

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
