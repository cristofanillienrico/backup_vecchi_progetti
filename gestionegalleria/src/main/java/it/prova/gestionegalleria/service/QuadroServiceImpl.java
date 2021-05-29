package it.prova.gestionegalleria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionegalleria.dao.EntityManagerUtil;
import it.prova.gestionegalleria.dao.IQuadroDAO;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;
import it.prova.gestionegalleria.model.Tinta;

public class QuadroServiceImpl implements IQuadroService {

	private IQuadroDAO quadroDAO;

	@Override
	public void setQuadroDAO(IQuadroDAO quadroDAO) {
		this.quadroDAO = quadroDAO;

	}

	@Override
	public List<Quadro> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return quadroDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Quadro caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return quadroDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Quadro quadroInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			quadroDAO.update(quadroInstance);

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
	public void inserisciNuovo(Quadro quadroInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			quadroDAO.insert(quadroInstance);

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
	public void rimuovi(Quadro quadroInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate il reparto
			quadroInstance = entityManager.merge(quadroInstance);

			// dissocio le categorie
			quadroInstance.getTinte().clear();

			// eseguo quello che realmente devo fare
			quadroDAO.delete(quadroInstance);

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
	public void aggiungiTinta(Quadro quadroInstance, Tinta tintaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// faccio merge
			quadroInstance = entityManager.merge(quadroInstance);
			tintaInstance = entityManager.merge(tintaInstance);

			// aggiungo addetto al reparto
			quadroInstance.getTinte().add(tintaInstance);

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
	public void aggiungiRestauratore(Quadro quadroInstance, Restauratore restauratoreInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			quadroDAO.setEntityManager(entityManager);

			// faccio merge
			quadroInstance = entityManager.merge(quadroInstance);
			restauratoreInstance = entityManager.merge(restauratoreInstance);

			// aggiungo addetto al reparto
			quadroInstance.getRestauratori().add(restauratoreInstance);

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
