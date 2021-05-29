package it.prova.service;

import it.prova.dao.automobile.AutomobileDAOImpl;
import it.prova.dao.compagniaassicurativa.CompagniaAssicurativaDAOImpl;
import it.prova.dao.proprietario.ProprietarioDAOImpl;
import it.prova.service.automobile.AutomobileServiceImpl;
import it.prova.service.automobile.IAutomobileService;
import it.prova.service.compagniaassicurativa.CompagniaAssicurativaServiceImpl;
import it.prova.service.compagniaassicurativa.ICompagniaAssicurativaService;
import it.prova.service.proprietario.IProprietarioService;
import it.prova.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {

	public static ICompagniaAssicurativaService getICompagniaAssicurativaService() {
		ICompagniaAssicurativaService compagniaAssicurativaService = new CompagniaAssicurativaServiceImpl();
		compagniaAssicurativaService.setCompagniaAssicurativaDao(new CompagniaAssicurativaDAOImpl());
		return compagniaAssicurativaService;
	}

	public static IProprietarioService getIProprietarioService() {
		IProprietarioService proprietarioService = new ProprietarioServiceImpl();
		proprietarioService.setProprietarioDao(new ProprietarioDAOImpl());
		proprietarioService.setAutomobileDao(new AutomobileDAOImpl());
		return proprietarioService;
	}

	public static IAutomobileService getIAutomobileService() {
		IAutomobileService automobileService = new AutomobileServiceImpl();
		automobileService.setAutomobileDao(new AutomobileDAOImpl());
		automobileService.setProprietarioDao(new ProprietarioDAOImpl());
		automobileService.setCompagniaAssicurativaDao(new CompagniaAssicurativaDAOImpl());
		return automobileService;
	}

}
