package it.prova.gestioneaudit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneaudit.model.CodiceEsitoOperazione;
import it.prova.gestioneaudit.model.Ruolo;

public class RuoloDAOImpl implements RuoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ruolo> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Ruolo", Ruolo.class).getResultList();
	}

	@Override
	public Ruolo get(Long id) throws Exception {
		return entityManager.find(Ruolo.class, id);
	}

	@Override
	public void update(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		ruoloInstance = entityManager.merge(ruoloInstance);

	}

	@Override
	public void insert(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(ruoloInstance);

	}

	@Override
	public void delete(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(ruoloInstance));

	}

	@Override
	public Ruolo findByDescrizioneAndCodice(String descrizione, String codice) throws Exception {
		TypedQuery<Ruolo> query = entityManager
				.createQuery("select r from Ruolo r where r.descrizione=?1 and r.codice=?2", Ruolo.class)
				.setParameter(1, descrizione).setParameter(2, codice);

		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Ruolo> allRuoliOfUtentiAssociatedAToCodiceEsitoOperazione(CodiceEsitoOperazione input)
			throws Exception {
		TypedQuery<Ruolo> query = entityManager.createQuery(
				"select r from Audit a join a.utente u join u.ruoli r where a.codiceEsitoOperazione=:codice",
				Ruolo.class).setParameter("codice", input);

		return query.getResultList();
	}

	@Override
	public List<String> allPasswordUtentiAssociatedToRuolo(Ruolo ruoloInput) throws Exception {
		TypedQuery<String> query = entityManager
				.createQuery("select u.password from Utente u join u.ruoli r where r=:ruolo", String.class)
				.setParameter("ruolo", ruoloInput);

		return query.getResultList();
	}

}
