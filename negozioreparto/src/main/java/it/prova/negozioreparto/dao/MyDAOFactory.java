package it.prova.negozioreparto.dao;

public class MyDAOFactory {

	// rendiamo questo factory SINGLETON
	private static INegozioDAO NEGOZIO_DAO_INSTANCE = null;
	private static IRepartoDAO REPARTO_DAO_INSTANCE = null;
	private static IAddettoDAO ADDETTO_DAO_INSTANCE = null;

	public static INegozioDAO getNegozioDAOInstance() {
		if (NEGOZIO_DAO_INSTANCE == null)
			NEGOZIO_DAO_INSTANCE = new NegozioDAOImpl();
		return NEGOZIO_DAO_INSTANCE;
	}

	public static IRepartoDAO getRepartoDAOInstance() {
		if (REPARTO_DAO_INSTANCE == null)
			REPARTO_DAO_INSTANCE = new RepartoDAOImpl();
		return REPARTO_DAO_INSTANCE;
	}

	public static IAddettoDAO getAddettoDAOInstance() {
		if (ADDETTO_DAO_INSTANCE == null)
			ADDETTO_DAO_INSTANCE = new AddettoDAOImpl();
		return ADDETTO_DAO_INSTANCE;
	}

}
