package it.prova.gestioneaudit.dao;

public class MyDAOFactory {

	// rendiamo questo factory SINGLETON
	private static UtenteDAO UTENTE_DAO_INSTANCE = null;
	private static RuoloDAO RUOLO_DAO_INSTANCE = null;
	private static AuditDAO AUDIT_DAO_INSTANCE = null;

	public static UtenteDAO getUtenteDAOInstance() {
		if (UTENTE_DAO_INSTANCE == null)
			UTENTE_DAO_INSTANCE = new UtenteDAOImpl();
		return UTENTE_DAO_INSTANCE;
	}

	public static RuoloDAO getRuoloDAOInstance() {
		if (RUOLO_DAO_INSTANCE == null)
			RUOLO_DAO_INSTANCE = new RuoloDAOImpl();
		return RUOLO_DAO_INSTANCE;
	}

	public static AuditDAO getAuditDAOInstance() {
		if (AUDIT_DAO_INSTANCE == null)
			AUDIT_DAO_INSTANCE = new AuditDAOImpl();
		return AUDIT_DAO_INSTANCE;
	}

}
