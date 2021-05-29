package it.prova.ordinearticolo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.ordinearticolo.model.Articolo;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;

public class ArticoloDAOImpl implements IArticoloDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Articolo> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		articoloInstance = entityManager.merge(articoloInstance);

	}

	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(articoloInstance);

	}

	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(articoloInstance));

	}

	@Override
	public List<Articolo> findAllByOrdine(Ordine ordineInstance) throws Exception {
		TypedQuery<Articolo> query = entityManager
				.createQuery("select a FROM Articolo a join a.ordine o where o = :ordine", Articolo.class);
		query.setParameter("ordine", ordineInstance);
		return query.getResultList();
	}

	@Override
	public Double sumPriceArticoliLinkToCategoria(Categoria categoriaInstance) throws Exception {
		TypedQuery<Double> query = entityManager
				.createQuery("select sum(a.prezzoUnitario) FROM Articolo a join a.categorie c where c = :categoria", Double.class);
		query.setParameter("categoria", categoriaInstance);
		return query.getSingleResult();
	}

}
