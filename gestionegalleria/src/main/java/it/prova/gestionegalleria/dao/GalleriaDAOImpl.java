package it.prova.gestionegalleria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestionegalleria.model.Galleria;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public class GalleriaDAOImpl implements IGalleriaDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Galleria> list() throws Exception {
		return entityManager.createQuery("from Galleria", Galleria.class).getResultList();
	}

	@Override
	public Galleria get(Long id) throws Exception {
		return entityManager.find(Galleria.class, id);
	}

	@Override
	public void update(Galleria galleriaInstance) throws Exception {
		if (galleriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		galleriaInstance = entityManager.merge(galleriaInstance);
	}

	@Override
	public void insert(Galleria galleriaInstance) throws Exception {
		if (galleriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(galleriaInstance);

	}

	@Override
	public void delete(Galleria galleriaInstance) throws Exception {
		if (galleriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(galleriaInstance));

	}

	@Override
	public List<Quadro> allQuadriByGalleria(Galleria galleriaInstance) throws Exception {
		if (galleriaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<Quadro> query = entityManager
				.createQuery("select q FROM Galleria g join g.quadri q where g=:galleria", Quadro.class);

		query.setParameter("galleria", galleriaInstance);

		return query.getResultList();
	}

	@Override
	public List<String> addressGallerieWhereUsedATinta(Tinta tintaInstance) throws Exception {
		if (tintaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<String> query = entityManager.createQuery(
				"select distinct g.indirizzo FROM Galleria g join g.quadri q join q.tinte t where t=:tinta",
				String.class);

		query.setParameter("tinta", tintaInstance);

		return query.getResultList();
	}

}
