package it.prova.ordinearticolo.service;

import it.prova.ordinearticolo.dao.MyDAOFactory;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static IArticoloService ARTICOLO_SERVICE_INSTANCE;
	private static ICategoriaService CATEGORIA_SERVICE_INSTANCE;
	private static IOrdineService ORDINE_SERVICE_INSTANCE;
	

	public static IArticoloService getArticoloServiceInstance() {
		if (ARTICOLO_SERVICE_INSTANCE == null)
			ARTICOLO_SERVICE_INSTANCE = new ArticoloServiceImpl();

		ARTICOLO_SERVICE_INSTANCE.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());
		return ARTICOLO_SERVICE_INSTANCE;
	}
	
	public static ICategoriaService getCategoriaServiceInstance() {
		if (CATEGORIA_SERVICE_INSTANCE == null)
			CATEGORIA_SERVICE_INSTANCE = new CategoriaServiceImpl();

		CATEGORIA_SERVICE_INSTANCE.setCategoriaDAO(MyDAOFactory.getCategoriaDAOInstance());
		CATEGORIA_SERVICE_INSTANCE.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());

		return CATEGORIA_SERVICE_INSTANCE;
	}
	
	public static IOrdineService getOrdineServiceInstance() {
		if (ORDINE_SERVICE_INSTANCE == null)
			ORDINE_SERVICE_INSTANCE = new OrdineServiceImpl();

		ORDINE_SERVICE_INSTANCE.setOrdineDAO(MyDAOFactory.getOrdineDAOInstance());
		ORDINE_SERVICE_INSTANCE.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());
		return ORDINE_SERVICE_INSTANCE;
	}

	

}
