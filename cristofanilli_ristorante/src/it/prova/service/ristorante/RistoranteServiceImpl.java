package it.prova.service.ristorante;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.EntityManagerUtil;
import it.prova.dao.ristorante.IRistoranteDAO;
import it.prova.model.Ristorante;

public class RistoranteServiceImpl implements IRistoranteService {

	private IRistoranteDAO ristoranteDao;

	@Override
	public void setRistoranteDAO(IRistoranteDAO ristoranteDAO) {
		this.ristoranteDao = ristoranteDAO;

	}

	@Override
	public List<Ristorante> listAllRistoranti() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ristoranteDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Ristorante caricaSingoloRistorante(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ristoranteDao.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Ristorante caricaSingoloRistoranteConClienti(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ristoranteDao.getEagerClienti(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Ristorante ristoranteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ristoranteDao.update(ristoranteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Ristorante ristoranteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ristoranteDao.insert(ristoranteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Ristorante ristoranteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ristoranteDao.setEntityManager(entityManager);
			
			//controllo che sia vuoto prima della chiusura
			ristoranteDao.getEagerClienti(ristoranteInstance.getId());
			if(ristoranteInstance.getClienti()!=null) {
				throw new Exception("Prima di chiudere il ristorante i clienti devono essere andati via");
				
			}

			// eseguo quello che realmente devo fare
			ristoranteDao.delete(ristoranteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;

		}

	}
}
