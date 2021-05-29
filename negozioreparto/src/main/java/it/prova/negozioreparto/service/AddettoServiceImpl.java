package it.prova.negozioreparto.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.negozioreparto.dao.EntityManagerUtil;
import it.prova.negozioreparto.dao.IAddettoDAO;
import it.prova.negozioreparto.model.Addetto;
import it.prova.negozioreparto.model.Reparto;

public class AddettoServiceImpl implements IAddettoService {

	private IAddettoDAO addettoDAO;

	@Override
	public void setAddettoDAO(IAddettoDAO addettoDAO) {
		this.addettoDAO = addettoDAO;

	}

	@Override
	public List<Addetto> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			addettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return addettoDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Addetto caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			addettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return addettoDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Addetto addettoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			addettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			addettoDAO.update(addettoInstance);

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
	public void inserisciNuovo(Addetto addettoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			addettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			addettoDAO.insert(addettoInstance);

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
	public void rimuovi(Addetto addettoInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			addettoDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate il reparto
			addettoInstance = entityManager.merge(addettoInstance);

			// inserisco tutti i reparti in una lista
			List<Reparto> listaReparti = addettoDAO.tuttiRepartiDaAddetto(addettoInstance);

			// dissocio il dato addetto da tali reparti
			for (Reparto repartoItem : listaReparti) {
				repartoItem.getAddetti().remove(addettoInstance);

			}

			// eseguo quello che realmente devo fare
			addettoDAO.delete(addettoInstance);

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
