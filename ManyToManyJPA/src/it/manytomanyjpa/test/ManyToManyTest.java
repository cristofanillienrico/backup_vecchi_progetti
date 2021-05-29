package it.manytomanyjpa.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.manytomanyjpa.dao.EntityManagerUtil;
import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;
import it.manytomanyjpa.service.MyServiceFactory;
import it.manytomanyjpa.service.RuoloService;
import it.manytomanyjpa.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// Data accessoria
		Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
		Date myDate = myCalendar.getTime();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
//			initRuoli(ruoloServiceInstance);
//
//			System.out.println("Elenca utenti: ");
//			for (Utente utenteItem : utenteServiceInstance.listAll()) {
//				System.out.println(utenteItem);
//			}

//			Utente utenteNuovo = new Utente("pippo.rossi", "xxx", "pippo", "rossi", new Date());
//			utenteServiceInstance.inserisciNuovo(utenteNuovo);
//
//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);
//
//			Utente utenteDaDb = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
//			if (utenteDaDb != null) {
//				utenteServiceInstance.aggiungiRuolo(utenteDaDb, ruoloDaDb);
//			}

			// proviamo a passarlo nello stato ATTIVO
//			Utente utenteDaDb2 = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
//			if (utenteDaDb2 != null) {
//				System.out.println(
//						"stato attuale dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//				utenteDaDb2.setStato(StatoUtente.ATTIVO);
//				utenteServiceInstance.aggiorna(utenteDaDb2);
//				System.out.println(
//						"stato nuovo dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//			}

			// METODI DI RUOLO

			// list all di ruolo
//			System.out.println(ruoloServiceInstance.listAll());

			// get di ruolo
//			System.out.println(ruoloServiceInstance.caricaSingoloElemento(1L));

			// Inserisci ruolo
//			Ruolo mioRuolo=new Ruolo("Imperatore","ROLE_IMPERATORE");
//			ruoloServiceInstance.inserisciNuovo(mioRuolo);

			// Aggiorna ruolo
//			Ruolo ruoloDaAggiornare=ruoloServiceInstance.caricaSingoloElemento(3L);
//			ruoloDaAggiornare.setDescrizione("Aggiornato");
//			ruoloServiceInstance.aggiorna(ruoloDaAggiornare);

			// Elimino ruolo che non è utilizzato
//			Ruolo ruoloEliminare=ruoloServiceInstance.caricaSingoloElemento(3L);
//			ruoloServiceInstance.rimuovi(ruoloEliminare);

			// Elimino ruolo che è utilizzato
//			Ruolo ruoloEliminare=ruoloServiceInstance.caricaSingoloElemento(1L);
//			ruoloServiceInstance.rimuovi(ruoloEliminare);

			// cerca per descrizione e codice
//			System.out.println(ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));

			// METODI DI UTENTE

			// get utente
//			System.out.println(utenteServiceInstance.caricaSingoloElemento(1L));

			// list all utente
//			System.out.println(utenteServiceInstance.listAll());

			// inserisci utente
//			Utente mioUtente = new Utente("mioNick","fd34r43r","Giacomo","Mangelli",myDate);
//			utenteServiceInstance.inserisciNuovo(mioUtente);

			// aggiorna utente
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(3L);
//			mioUtente.setNome("Ugula");
//			utenteServiceInstance.aggiorna(mioUtente);

			// elimina utente
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(3L);
//			utenteServiceInstance.rimuovi(mioUtente);

			// aggiungi ruolo
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(2L);
//			Ruolo mioRuolo=ruoloServiceInstance.caricaSingoloElemento(2L);
//			utenteServiceInstance.aggiungiRuolo(mioUtente, mioRuolo);
			
			
			//disassociare utente ruolo
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(2L);
//			Ruolo mioRuolo=ruoloServiceInstance.caricaSingoloElemento(2L);
//			utenteServiceInstance.disaccoppiaUtenteRuolo(mioUtente, mioRuolo);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
		}
	}

}
