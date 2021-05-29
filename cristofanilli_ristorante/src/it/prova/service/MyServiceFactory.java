package it.prova.service;

import it.prova.dao.MyDaoFactory;
import it.prova.service.cliente.ClienteServiceImpl;
import it.prova.service.cliente.IClienteService;
import it.prova.service.ristorante.IRistoranteService;
import it.prova.service.ristorante.RistoranteServiceImpl;

public class MyServiceFactory {

	// rendiamo le istanze restituite SINGLETON
	private static IClienteService clienteServiceInstance = null;
	private static IRistoranteService ristoranteServiceInstance = null;

	public static IClienteService getClienteServiceInstance() {
		if (clienteServiceInstance == null) {
			clienteServiceInstance = new ClienteServiceImpl();
			clienteServiceInstance.setClienteDAO(MyDaoFactory.getClienteDAOInstance());
			clienteServiceInstance.setRistoranteDAO(MyDaoFactory.getRistoranteDAOInstance());
		}
		return clienteServiceInstance;
	}

	public static IRistoranteService getRistoranteServiceInstance() {
		if (ristoranteServiceInstance == null) {
			ristoranteServiceInstance = new RistoranteServiceImpl();
			ristoranteServiceInstance.setRistoranteDAO(MyDaoFactory.getRistoranteDAOInstance());
		}
		return ristoranteServiceInstance;
	}

}
