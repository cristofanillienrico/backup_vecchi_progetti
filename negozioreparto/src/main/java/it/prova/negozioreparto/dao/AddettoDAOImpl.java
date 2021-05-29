package it.prova.negozioreparto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.negozioreparto.model.Addetto;
import it.prova.negozioreparto.model.Reparto;

public class AddettoDAOImpl implements IAddettoDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Addetto> list() throws Exception {
		return entityManager.createQuery("from Addetto", Addetto.class).getResultList();
	}

	@Override
	public Addetto get(Long id) throws Exception {
		return entityManager.find(Addetto.class, id);
	}

	@Override
	public void update(Addetto addettoInstance) throws Exception {
		if (addettoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		addettoInstance = entityManager.merge(addettoInstance);

	}

	@Override
	public void insert(Addetto addettoInstance) throws Exception {
		if (addettoInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(addettoInstance);

	}

	@Override
	public void delete(Addetto addettoInstance) throws Exception {
		if (addettoInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(addettoInstance));

	}

	@Override
	public List<Reparto> tuttiRepartiDaAddetto(Addetto addettoInstance) throws Exception {
		TypedQuery<Reparto> query = entityManager
				.createQuery("select r FROM Addetto a join a.reparti r where a=:addetto ", Reparto.class);

		query.setParameter("addetto", addettoInstance);

		return query.getResultList();

	}

}
