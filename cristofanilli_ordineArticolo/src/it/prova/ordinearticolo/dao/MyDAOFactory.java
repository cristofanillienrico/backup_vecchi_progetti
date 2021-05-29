package it.prova.ordinearticolo.dao;

public class MyDAOFactory {

	// rendiamo questo factory SINGLETON
	private static IArticoloDAO ARTICOLO_DAO_INSTANCE = null;
	private static ICategoriaDAO CATEGORIA_DAO_INSTANCE = null;
	private static IOrdineDAO ORDINE_DAO_INSTANCE = null;

	public static IArticoloDAO getArticoloDAOInstance() {
		if (ARTICOLO_DAO_INSTANCE == null)
			ARTICOLO_DAO_INSTANCE = new ArticoloDAOImpl();
		return ARTICOLO_DAO_INSTANCE;
	}

	public static IOrdineDAO getOrdineDAOInstance() {
		if (ORDINE_DAO_INSTANCE == null)
			ORDINE_DAO_INSTANCE = new OrdineDAOImpl();
		return ORDINE_DAO_INSTANCE;
	}
	
	public static ICategoriaDAO getCategoriaDAOInstance() {
		if (CATEGORIA_DAO_INSTANCE == null)
			CATEGORIA_DAO_INSTANCE = new CategoriaDAOImpl();
		return CATEGORIA_DAO_INSTANCE;
	}

}
