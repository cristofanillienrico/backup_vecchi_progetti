package it.prova.dao.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.model.Cliente;

public class ClienteDAOImpl implements IClienteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Cliente> list() throws Exception {
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@Override
	public Cliente get(Long id) throws Exception {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public void update(Cliente clienteInstance) throws Exception {
		if (clienteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		clienteInstance = entityManager.merge(clienteInstance);

	}

	@Override
	public void insert(Cliente clienteInstance) throws Exception {
		if (clienteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(clienteInstance);

	}

	@Override
	public void delete(Cliente clienteInstance) throws Exception {
		if (clienteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(clienteInstance));

	}

}
