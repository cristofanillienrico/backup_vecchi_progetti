package it.prova.gestioneaudit.service;

import it.prova.gestioneaudit.dao.MyDAOFactory;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static UtenteService UTENTE_SERVICE_INSTANCE;
	private static RuoloService RUOLO_SERVICE_INSTANCE;
	private static AuditService AUDIT_SERVICE_INSTANCE;

	public static UtenteService getUtenteServiceInstance() {
		if (UTENTE_SERVICE_INSTANCE == null)
			UTENTE_SERVICE_INSTANCE = new UtenteServiceImpl();

		UTENTE_SERVICE_INSTANCE.setUtenteDAO(MyDAOFactory.getUtenteDAOInstance());
		return UTENTE_SERVICE_INSTANCE;
	}

	public static RuoloService getRuoloServiceInstance() {
		if (RUOLO_SERVICE_INSTANCE == null)
			RUOLO_SERVICE_INSTANCE = new RuoloServiceImpl();

		RUOLO_SERVICE_INSTANCE.setRuoloDAO(MyDAOFactory.getRuoloDAOInstance());
		RUOLO_SERVICE_INSTANCE.setUtenteDAO(MyDAOFactory.getUtenteDAOInstance());

		return RUOLO_SERVICE_INSTANCE;
	}

	public static AuditService getAuditServiceInstance() {
		if (AUDIT_SERVICE_INSTANCE == null)
			AUDIT_SERVICE_INSTANCE = new AuditServiceImpl();

		AUDIT_SERVICE_INSTANCE.setAuditDAO(MyDAOFactory.getAuditDAOInstance());
		return AUDIT_SERVICE_INSTANCE;
	}

}
