package it.prova.negozioreparto.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.negozioreparto.model.Reparto;

public class RepartoDAOImpl implements IRepartoDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Reparto> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Reparto", Reparto.class).getResultList();
	}

	@Override
	public Reparto get(Long id) throws Exception {
		return entityManager.find(Reparto.class, id);
	}

	@Override
	public void update(Reparto repartoInstance) throws Exception {
		if (repartoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		repartoInstance = entityManager.merge(repartoInstance);

	}

	@Override
	public void insert(Reparto repartoInstance) throws Exception {
		if (repartoInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(repartoInstance);

	}

	@Override
	public void delete(Reparto repartoInstance) throws Exception {
		if (repartoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(repartoInstance));

	}

}
