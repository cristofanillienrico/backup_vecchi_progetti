package service;

import dao.autore.AutoreDAOImpl;
import dao.casadiscografica.CasaDiscograficaDAOImpl;
import dao.cd.CdDAOImpl;
import service.autore.AutoreService;
import service.autore.AutoreServiceImpl;
import service.casadiscografica.CasaDiscograficaService;
import service.casadiscografica.CasaDiscograficaServiceImpl;
import service.cd.CdService;
import service.cd.CdServiceImpl;

public class MyServiceFactory {
	
	public static AutoreService getAutoreServiceImpl() {
		AutoreService autoreService = new AutoreServiceImpl();
		autoreService.setAutoreDao(new AutoreDAOImpl());
		autoreService.setCdDao(new CdDAOImpl());
		return autoreService;
	}
	
	public static CasaDiscograficaService getCasaDiscograficaServiceImpl() {
		CasaDiscograficaService casaDiscograficaService = new CasaDiscograficaServiceImpl();
		casaDiscograficaService.setCasaDiscograficaDao(new CasaDiscograficaDAOImpl());
		casaDiscograficaService.setAutoreDao(new AutoreDAOImpl() );
		return casaDiscograficaService;
	}
	
	public static CdService getCdServiceImpl() {
		CdService cdService = new CdServiceImpl();
		cdService.setCdDao(new CdDAOImpl());
		return cdService;
	}
	
	
	

}
