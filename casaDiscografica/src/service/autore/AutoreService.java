package service.autore;

import java.util.List;

import dao.autore.AutoreDAO;
import dao.cd.CdDAO;
import model.Autore;
import model.CasaDiscografica;



public interface AutoreService {
	// questo mi serve per injection
		public void setAutoreDao(AutoreDAO userDao);
		public void setCdDao(CdDAO cdDao);

		public List<Autore> listAll() throws Exception;

		public Autore findById(Long idInput) throws Exception;

		public int aggiorna(Autore input) throws Exception;

		public int inserisciNuovo(Autore input) throws Exception;

		public int rimuovi(Autore input) throws Exception;

		public List<Autore> findByExample(Autore input) throws Exception;
		
		public void popolaCd(Autore autore) throws Exception;
		
		public List<Autore> trovaTuttiPerCasaDiscografica(CasaDiscografica input) throws Exception;
		
		public List<Autore> trovaConCdDoveTracceMaggioriDi(int nTracce) throws Exception;
		
		
}
