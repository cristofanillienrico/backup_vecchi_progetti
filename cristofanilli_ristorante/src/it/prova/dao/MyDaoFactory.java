package it.prova.dao;

import it.prova.dao.cliente.ClienteDAOImpl;
import it.prova.dao.cliente.IClienteDAO;
import it.prova.dao.ristorante.IRistoranteDAO;
import it.prova.dao.ristorante.RistoranteDAOImpl;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static IClienteDAO clienteDAOInstance = null;
	private static IRistoranteDAO ristoranteDAOInstance = null;

	public static IClienteDAO getClienteDAOInstance() {
		if (clienteDAOInstance == null)
			clienteDAOInstance = new ClienteDAOImpl();
		return clienteDAOInstance;
	}

	public static IRistoranteDAO getRistoranteDAOInstance() {
		if (ristoranteDAOInstance == null)
			ristoranteDAOInstance = new RistoranteDAOImpl();
		return ristoranteDAOInstance;
	}

}
