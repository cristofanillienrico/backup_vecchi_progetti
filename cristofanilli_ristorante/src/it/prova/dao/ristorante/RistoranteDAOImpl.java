package it.prova.dao.ristorante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.model.Ristorante;

public class RistoranteDAOImpl implements IRistoranteDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ristorante> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Ristorante", Ristorante.class).getResultList();
	}

	@Override
	public Ristorante get(Long id) throws Exception {
		return entityManager.find(Ristorante.class, id);
	}

	@Override
	public Ristorante getEagerClienti(Long id) throws Exception {

		TypedQuery<Ristorante> query = entityManager
				.createQuery("select r from Ristorante r left join fetch r.clienti where r.id=?1", Ristorante.class);
		query.setParameter(1, id);

		// return query.getSingleResult() ha il problema che se non trova elementi
		// lancia NoResultException
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public void update(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		ristoranteInstance = entityManager.merge(ristoranteInstance);

	}

	@Override
	public void insert(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(ristoranteInstance);

	}

	@Override
	public void delete(Ristorante ristoranteInstance) throws Exception {
		if (ristoranteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ristoranteInstance));

	}

}
