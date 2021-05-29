package service.casadiscografica;

import java.util.List;

import dao.autore.AutoreDAO;
import dao.casadiscografica.CasaDiscograficaDAO;
import model.Autore;
import model.CasaDiscografica;

public interface CasaDiscograficaService {
	// questo mi serve per injection
			public void setCasaDiscograficaDao(CasaDiscograficaDAO casaDiscograficaDao);
			public void setAutoreDao(AutoreDAO autoreDao);

			public List<CasaDiscografica> listAll() throws Exception;

			public CasaDiscografica findById(Long idInput) throws Exception;

			public int aggiorna(CasaDiscografica input) throws Exception;

			public int inserisciNuovo(CasaDiscografica input) throws Exception;

			public int rimuovi(CasaDiscografica input) throws Exception;

			public List<CasaDiscografica> findByExample(CasaDiscografica input) throws Exception;
			
			public CasaDiscografica casaDiscograficaTrovaDaAutore(Autore input) throws Exception;
			
			public List<CasaDiscografica> trovaTuttiDaAutoreDoveCognomeIniziaCon(String iniziale) throws Exception;
			
			public List<CasaDiscografica> trovaTuttiDaCdDoveGenereUgualeA(String genere) throws Exception;
}
