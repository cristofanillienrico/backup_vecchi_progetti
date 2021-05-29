package it.prova.gestionegalleria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public class TintaDAOImpl implements ITintaDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Tinta> list() throws Exception {
		return entityManager.createQuery("from Tinta", Tinta.class).getResultList();
	}

	@Override
	public Tinta get(Long id) throws Exception {
		return entityManager.find(Tinta.class, id);
	}

	@Override
	public void update(Tinta tintaInstance) throws Exception {
		if (tintaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		tintaInstance = entityManager.merge(tintaInstance);
	}

	@Override
	public void insert(Tinta tintaInstance) throws Exception {
		if (tintaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(tintaInstance);

	}

	@Override
	public void delete(Tinta tintaInstance) throws Exception {
		if (tintaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(tintaInstance));

	}

	@Override
	public List<Quadro> tuttiQuadriDaTinta(Tinta tintaInstance) throws Exception {
		TypedQuery<Quadro> query = entityManager.createQuery("select q FROM Tinta t join t.quadri q where t=:tinta",
				Quadro.class);

		query.setParameter("tinta", tintaInstance);

		return query.getResultList();
	}

}
