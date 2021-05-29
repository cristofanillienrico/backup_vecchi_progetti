package it.prova.gestionegalleria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionegalleria.dao.EntityManagerUtil;
import it.prova.gestionegalleria.dao.ITintaDAO;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public class TintaServiceImpl implements ITintaService {

	private ITintaDAO tintaDAO;

	@Override
	public void setTintaDAO(ITintaDAO tintaDAO) {
		this.tintaDAO = tintaDAO;

	}

	@Override
	public List<Tinta> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			tintaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return tintaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Tinta caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			tintaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return tintaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Tinta tintaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tintaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			tintaDAO.update(tintaInstance);

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
	public void inserisciNuovo(Tinta tintaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tintaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			tintaDAO.insert(tintaInstance);

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
	public void rimuovi(Tinta tintaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			tintaDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate il reparto
			tintaInstance = entityManager.merge(tintaInstance);

			// inserisco tutti i reparti in una lista
			List<Quadro> listaQuadri = tintaDAO.tuttiQuadriDaTinta(tintaInstance);

			// dissocio il dato addetto da tali reparti
			for (Quadro quadroItem : listaQuadri) {
				quadroItem.getTinte().remove(tintaInstance);

			}

			// eseguo quello che realmente devo fare
			tintaDAO.delete(tintaInstance);

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
