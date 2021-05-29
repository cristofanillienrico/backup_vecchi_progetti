package it.prova.negozioreparto.service;

import it.prova.negozioreparto.dao.MyDAOFactory;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static INegozioService NEGOZIO_SERVICE_INSTANCE;
	private static IRepartoService REPARTO_SERVICE_INSTANCE;
	private static IAddettoService ADDETTO_SERVICE_INSTANCE;

	public static INegozioService getNegozioServiceInstance() {
		if (NEGOZIO_SERVICE_INSTANCE == null)
			NEGOZIO_SERVICE_INSTANCE = new NegozioServiceImpl();

		NEGOZIO_SERVICE_INSTANCE.setNegozioDAO(MyDAOFactory.getNegozioDAOInstance());
		return NEGOZIO_SERVICE_INSTANCE;
	}

	public static IRepartoService getRepartoServiceInstance() {
		if (REPARTO_SERVICE_INSTANCE == null)
			REPARTO_SERVICE_INSTANCE = new RepartoServiceImpl();

		REPARTO_SERVICE_INSTANCE.setRepartoDAO(MyDAOFactory.getRepartoDAOInstance());

		return REPARTO_SERVICE_INSTANCE;
	}

	public static IAddettoService getAddettoServiceInstance() {
		if (ADDETTO_SERVICE_INSTANCE == null)
			ADDETTO_SERVICE_INSTANCE = new AddettoServiceImpl();

		ADDETTO_SERVICE_INSTANCE.setAddettoDAO(MyDAOFactory.getAddettoDAOInstance());

		return ADDETTO_SERVICE_INSTANCE;
	}

}
