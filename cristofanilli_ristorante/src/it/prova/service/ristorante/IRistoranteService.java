package it.prova.service.ristorante;

import java.util.List;

import it.prova.dao.ristorante.IRistoranteDAO;
import it.prova.model.Ristorante;

public interface IRistoranteService {
	
	// per injection
		public void setRistoranteDAO(IRistoranteDAO ristoranteDAO);

		public List<Ristorante> listAllRistoranti() throws Exception;

		public Ristorante caricaSingoloRistorante(Long id) throws Exception;
		
		public Ristorante caricaSingoloRistoranteConClienti(Long id) throws Exception;

		public void aggiorna(Ristorante ristoranteInstance) throws Exception;

		public void inserisciNuovo(Ristorante ristoranteInstance) throws Exception;

		public void rimuovi(Ristorante ristoranteInstance) throws Exception;

}
