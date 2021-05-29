package it.prova.gestionegalleria.dao;

public class MyDAOFactory {

	// rendiamo questo factory SINGLETON
	private static IGalleriaDAO GALLERIA_DAO_INSTANCE = null;
	private static IQuadroDAO QUADRO_DAO_INSTANCE = null;
	private static ITintaDAO TINTA_DAO_INSTANCE = null;
	private static IRestauratoreDAO RESTAURATORE_DAO_INSTANCE = null;

	public static IGalleriaDAO getGalleriaDAOInstance() {
		if (GALLERIA_DAO_INSTANCE == null)
			GALLERIA_DAO_INSTANCE = new GalleriaDAOImpl();
		return GALLERIA_DAO_INSTANCE;
	}

	public static IQuadroDAO getQuadroDAOInstance() {
		if (QUADRO_DAO_INSTANCE == null)
			QUADRO_DAO_INSTANCE = new QuadroDAOImpl();
		return QUADRO_DAO_INSTANCE;
	}

	public static ITintaDAO getTintaDAOInstance() {
		if (TINTA_DAO_INSTANCE == null)
			TINTA_DAO_INSTANCE = new TintaDAOImpl();
		return TINTA_DAO_INSTANCE;
	}

	public static IRestauratoreDAO getRestauratoreDAOInstance() {
		if (RESTAURATORE_DAO_INSTANCE == null)
			RESTAURATORE_DAO_INSTANCE = new RestauratoreDAOImpl();
		return RESTAURATORE_DAO_INSTANCE;
	}

}
