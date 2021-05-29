package it.prova.gestionegalleria.service;

import it.prova.gestionegalleria.dao.MyDAOFactory;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static IGalleriaService GALLERIA_SERVICE_INSTANCE;
	private static IQuadroService QUADRO_SERVICE_INSTANCE;
	private static ITintaService TINTA_SERVICE_INSTANCE;
	private static IRestauratoreService RESTAURATORE_SERVICE_INSTANCE;

	public static IGalleriaService getGalleriaServiceInstance() {
		if (GALLERIA_SERVICE_INSTANCE == null)
			GALLERIA_SERVICE_INSTANCE = new GalleriaServiceImpl();

		GALLERIA_SERVICE_INSTANCE.setGalleriaDAO(MyDAOFactory.getGalleriaDAOInstance());

		return GALLERIA_SERVICE_INSTANCE;
	}

	public static IQuadroService getQuadroServiceInstance() {
		if (QUADRO_SERVICE_INSTANCE == null)
			QUADRO_SERVICE_INSTANCE = new QuadroServiceImpl();

		QUADRO_SERVICE_INSTANCE.setQuadroDAO(MyDAOFactory.getQuadroDAOInstance());

		return QUADRO_SERVICE_INSTANCE;
	}

	public static ITintaService getTintaServiceInstance() {
		if (TINTA_SERVICE_INSTANCE == null)
			TINTA_SERVICE_INSTANCE = new TintaServiceImpl();

		TINTA_SERVICE_INSTANCE.setTintaDAO(MyDAOFactory.getTintaDAOInstance());

		return TINTA_SERVICE_INSTANCE;
	}

	public static IRestauratoreService getRestauratoreServiceInstance() {
		if (RESTAURATORE_SERVICE_INSTANCE == null)
			RESTAURATORE_SERVICE_INSTANCE = new RestauratoreServiceImpl();

		RESTAURATORE_SERVICE_INSTANCE.setRestauratoreDAO(MyDAOFactory.getRestauratoreDAOInstance());

		return RESTAURATORE_SERVICE_INSTANCE;
	}

}
