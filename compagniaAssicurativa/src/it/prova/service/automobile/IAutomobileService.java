package it.prova.service.automobile;

import java.util.List;

import it.prova.dao.automobile.IAutomobileDAO;
import it.prova.dao.compagniaassicurativa.ICompagniaAssicurativaDAO;
import it.prova.dao.proprietario.IProprietarioDAO;
import it.prova.model.Automobile;

public interface IAutomobileService {
	
	// questo mi serve per injection
			public void setAutomobileDao(IAutomobileDAO automobileDao);
			public void setProprietarioDao(IProprietarioDAO proprietarioDao);
			public void setCompagniaAssicurativaDao(ICompagniaAssicurativaDAO compagniaAssicurativaDAO);
			

			public List<Automobile> listAll() throws Exception;

			public Automobile findById(Long idInput) throws Exception;

			public int aggiorna(Automobile input) throws Exception;

			public int inserisciNuovo(Automobile input) throws Exception;

			public int rimuovi(Automobile input) throws Exception;

			public List<Automobile> findByExample(Automobile input) throws Exception;
			
			public List<Automobile> automobiliConProprietarioCheHaPiuDiQuarantaAnni() throws Exception;
			
			

}
