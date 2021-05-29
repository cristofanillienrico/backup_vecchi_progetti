package it.prova.gestioneaudit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneaudit.model.Audit;
import it.prova.gestioneaudit.model.Ruolo;

public class AuditDAOImpl implements AuditDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Audit> list() throws Exception {
		return entityManager.createQuery("from Audit", Audit.class).getResultList();
	}

	@Override
	public Audit get(Long id) throws Exception {
		return entityManager.find(Audit.class, id);
	}

	@Override
	public void update(Audit o) throws Exception {
		throw new Exception("Operazione non consentita");

	}

	@Override
	public void insert(Audit auditInstance) throws Exception {
		if (auditInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(auditInstance);

	}

	@Override
	public void delete(Audit o) throws Exception {
		throw new Exception("Operazione non consentita");

	}

	@Override
	public List<Audit> allAssociatedToThisRuolo(Ruolo ruoloInput) throws Exception {
		TypedQuery<Audit> query = entityManager
				.createQuery("select a from Audit a join a.utente u join u.ruoli r where r=:ruolo ", Audit.class)
				.setParameter("ruolo", ruoloInput);

		return query.getResultList();
	}

}
