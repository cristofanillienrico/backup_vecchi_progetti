package service.cd;

import java.util.List;

import dao.cd.CdDAO;
import model.Autore;
import model.Cd;

public interface CdService {
	// questo mi serve per injection
			public void setCdDao(CdDAO cdDao);

			public List<Cd> listAll() throws Exception;

			public Cd findById(Long idInput) throws Exception;

			public int aggiorna(Cd input) throws Exception;

			public int inserisciNuovo(Cd input) throws Exception;

			public int rimuovi(Cd input) throws Exception;

			public List<Cd> findByExample(Cd input) throws Exception;
			
			public List<Cd> trovaTuttiDaGenere(String genere) throws Exception;
			
			public List<Cd> trovaTuttiDaAutoreDoveTitoloIniziaCon(Autore autoreInput,String iniziale)throws Exception;
}
