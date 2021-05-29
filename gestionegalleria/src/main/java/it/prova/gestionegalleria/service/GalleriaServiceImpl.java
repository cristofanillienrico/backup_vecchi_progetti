package it.prova.gestionegalleria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionegalleria.dao.EntityManagerUtil;
import it.prova.gestionegalleria.dao.IGalleriaDAO;
import it.prova.gestionegalleria.model.Galleria;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public class GalleriaServiceImpl implements IGalleriaService {

	private IGalleriaDAO galleriaDAO;

	@Override
	public void setGalleriaDAO(IGalleriaDAO galleriaDAO) {
		this.galleriaDAO = galleriaDAO;
	}

	@Override
	public List<Galleria> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return galleriaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Galleria caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return galleriaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Galleria galleriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			galleriaDAO.update(galleriaInstance);

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
	public void inserisciNuovo(Galleria galleriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			galleriaDAO.insert(galleriaInstance);

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
	public void rimuovi(Galleria galleriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

//			 non posso cancellare negozi se hanno associati dei reparti
			if (!galleriaDAO.allQuadriByGalleria(galleriaInstance).isEmpty()) {
				throw new Exception("Non posso cancellare la Galleria finchè ci sono quadri dentro");
			}

			// eseguo quello che realmente devo fare
			galleriaDAO.delete(galleriaInstance);

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
	public List<Quadro> tuttiQuadriDataUnaGalleria(Galleria galleriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return galleriaDAO.allQuadriByGalleria(galleriaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiungiQuadro(Galleria galleriaInstance, Quadro quadroInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// faccio merge
			galleriaInstance = entityManager.merge(galleriaInstance);
			quadroInstance = entityManager.merge(quadroInstance);

			// aggiungo galleria al quadro che è il proprietario della relazione
			quadroInstance.setGalleria(galleriaInstance);

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
	public List<String> indirizziGallerieDoveUsataCertaTinta(Tinta tintaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			galleriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return galleriaDAO.addressGallerieWhereUsedATinta(tintaInstance);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

}
