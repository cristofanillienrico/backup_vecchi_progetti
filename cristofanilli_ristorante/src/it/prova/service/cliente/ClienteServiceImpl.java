package it.prova.service.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.EntityManagerUtil;
import it.prova.dao.cliente.IClienteDAO;
import it.prova.dao.ristorante.IRistoranteDAO;
import it.prova.model.Cliente;
import it.prova.model.Ristorante;

public class ClienteServiceImpl implements IClienteService {

	private IClienteDAO clienteDAO;
	private IRistoranteDAO ristoranteDao;

	@Override
	public void setClienteDAO(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;

	}
	
	@Override
	public void setRistoranteDAO(IRistoranteDAO ristoranteDAO) {
		this.ristoranteDao=ristoranteDAO;
		
	}

	@Override
	public List<Cliente> listAllClienti() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			clienteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return clienteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Cliente caricaSingoloCliente(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			clienteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return clienteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Cliente clienteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			clienteDAO.setEntityManager(entityManager);
			ristoranteDao.setEntityManager(entityManager);
			
			//verifico che il numero di coperti non sia stato raggiunto
			Ristorante ristoranteAssociatoAlCliente = ristoranteDao.getEagerClienti(clienteInstance.getRistorante().getId());
			if(ristoranteAssociatoAlCliente.getClienti().size()==ristoranteAssociatoAlCliente.getNumeroCoperti()) {
				throw new Exception("Il ristorante è pieno");
			}
			
			
			// eseguo quello che realmente devo fare
			clienteDAO.update(clienteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Cliente clienteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			clienteDAO.setEntityManager(entityManager);
			ristoranteDao.setEntityManager(entityManager);
			
			//verifico che il numero di coperti non sia stato raggiunto
			Ristorante ristoranteAssociatoAlCliente = ristoranteDao.getEagerClienti(clienteInstance.getRistorante().getId());
			if(ristoranteAssociatoAlCliente.getClienti().size()==ristoranteAssociatoAlCliente.getNumeroCoperti()) {
				throw new Exception("Il ristorante è pieno");
			}

			// eseguo quello che realmente devo fare
			clienteDAO.insert(clienteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Cliente clienteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			clienteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			clienteDAO.delete(clienteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	

}
