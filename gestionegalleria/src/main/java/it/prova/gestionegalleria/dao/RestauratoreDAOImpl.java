package it.prova.gestionegalleria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;

public class RestauratoreDAOImpl implements IRestauratoreDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Restauratore> list() throws Exception {
		return entityManager.createQuery("from Restauratore", Restauratore.class).getResultList();
	}

	@Override
	public Restauratore get(Long id) throws Exception {
		return entityManager.find(Restauratore.class, id);
	}

	@Override
	public void update(Restauratore restauratoreInstance) throws Exception {
		if (restauratoreInstance == null) {
			throw new Exception("Problema valore in input");
		}
		restauratoreInstance = entityManager.merge(restauratoreInstance);
	}

	@Override
	public void insert(Restauratore restauratoreInstance) throws Exception {
		if (restauratoreInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(restauratoreInstance);

	}

	@Override
	public void delete(Restauratore tintaInstance) throws Exception {
		if (tintaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(tintaInstance));

	}

	@Override
	public List<Quadro> tuttiQuadriDaRestauratore(Restauratore restauratoreInstance) throws Exception {
		TypedQuery<Quadro> query = entityManager
				.createQuery("select q FROM Restauratore r join r.quadri q where r=:restauratore ", Quadro.class);

		query.setParameter("restauratore", restauratoreInstance);

		return query.getResultList();
	}

}
