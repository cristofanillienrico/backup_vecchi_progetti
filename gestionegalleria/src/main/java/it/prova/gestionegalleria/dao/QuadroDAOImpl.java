package it.prova.gestionegalleria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionegalleria.model.Quadro;

public class QuadroDAOImpl implements IQuadroDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Quadro> list() throws Exception {
		return entityManager.createQuery("from Quadro", Quadro.class).getResultList();
	}

	@Override
	public Quadro get(Long id) throws Exception {
		return entityManager.find(Quadro.class, id);
	}

	@Override
	public void update(Quadro quadroInstance) throws Exception {
		if (quadroInstance == null) {
			throw new Exception("Problema valore in input");
		}
		quadroInstance = entityManager.merge(quadroInstance);
	}

	@Override
	public void insert(Quadro quadroInstance) throws Exception {
		if (quadroInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(quadroInstance);

	}

	@Override
	public void delete(Quadro quadroInstance) throws Exception {
		if (quadroInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(quadroInstance));

	}

}
