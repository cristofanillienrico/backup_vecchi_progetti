package it.prova.negozioreparto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.negozioreparto.model.Negozio;
import it.prova.negozioreparto.model.Reparto;

public class NegozioDAOImpl implements INegozioDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Negozio> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Negozio", Negozio.class).getResultList();
	}

	@Override
	public Negozio get(Long id) throws Exception {
		return entityManager.find(Negozio.class, id);
	}

	@Override
	public void update(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		negozioInstance = entityManager.merge(negozioInstance);

	}

	@Override
	public void insert(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(negozioInstance);

	}

	@Override
	public void delete(Negozio negozioInstance) throws Exception {
		if (negozioInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(negozioInstance));

	}

	@Override
	public List<Reparto> allRepartiByNegozio(Negozio negozioInstance) throws Exception {
		TypedQuery<Reparto> query = entityManager
				.createQuery("select r FROM Negozio n join n.reparti r  where n=:negozio", Reparto.class);

		query.setParameter("negozio", negozioInstance);

		return query.getResultList();
	}

	@Override
	public List<Negozio> listNegoziWithAddettoWithCognome(String cognomeInput) throws Exception {
		TypedQuery<Negozio> query = entityManager.createQuery(
				"select n FROM Negozio n join n.reparti r join r.addetti a where a.cognome=:cognome", Negozio.class);

		query.setParameter("cognome", cognomeInput);

		return query.getResultList();
	}

}
