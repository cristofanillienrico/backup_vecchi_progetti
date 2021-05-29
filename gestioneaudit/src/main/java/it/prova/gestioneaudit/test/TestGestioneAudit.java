package it.prova.gestioneaudit.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.prova.gestioneaudit.dao.EntityManagerUtil;
import it.prova.gestioneaudit.model.Utente;
import it.prova.gestioneaudit.service.AuditService;
import it.prova.gestioneaudit.service.MyServiceFactory;
import it.prova.gestioneaudit.service.RuoloService;
import it.prova.gestioneaudit.service.UtenteService;

public class TestGestioneAudit {

	public static void main(String[] args) {

		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();
		AuditService auditServiceInstance = MyServiceFactory.getAuditServiceInstance();

		// data accessoria
		Date myDate = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

		try {

//			********ESEGUO I TEST*********

			// **********METODI DI RUOLO**********

			// list all di ruolo
//			System.out.println(ruoloServiceInstance.listAll());

			// get di ruolo
//			System.out.println(ruoloServiceInstance.caricaSingoloElemento(1L));

//			 Inserisci ruolo
//			Ruolo mioRuolo=new Ruolo("Imperatore","ROLE_IMPERATORE");
//			ruoloServiceInstance.inserisciNuovo(mioRuolo);

			// Aggiorna ruolo
//			Ruolo ruoloDaAggiornare=ruoloServiceInstance.caricaSingoloElemento(3L);
//			ruoloDaAggiornare.setDescrizione("Aggiornato");
//			ruoloServiceInstance.aggiorna(ruoloDaAggiornare);

			// Elimino ruolo che non è utilizzato
//			Ruolo ruoloEliminare=ruoloServiceInstance.caricaSingoloElemento(4L);
//			ruoloServiceInstance.rimuovi(ruoloEliminare);

			// Elimino ruolo che è utilizzato
//			Ruolo ruoloEliminare=ruoloServiceInstance.caricaSingoloElemento(2L);
//			ruoloServiceInstance.rimuovi(ruoloEliminare);

			// cerca per descrizione e codice
//			System.out.println(ruoloServiceInstance.cercaPerDescrizioneECodice("Imperatore", "ROLE_IMPERATORE"));

			// **********METODI DI UTENTE**********

			// get utente
//			System.out.println(utenteServiceInstance.caricaSingoloElemento(1L));

			// list all utente
//			System.out.println(utenteServiceInstance.listAll());

			// inserisci utente
//			Utente mioUtente = new Utente("mioNick","fd34r43r","Giacomo","Mangelli",myDate);
//			utenteServiceInstance.inserisciNuovo(mioUtente);

			// aggiorna utente
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(1L);
//			mioUtente.setNome("Ugula");
//			utenteServiceInstance.aggiorna(mioUtente);

			// elimina utente con associato ruolo ATTENZIONE!!! LO RIMUOVE SENZA DISSOCIARE
			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(2L);
			utenteServiceInstance.rimuovi(mioUtente);

			// elimina utente con audit
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(1L);
//			utenteServiceInstance.rimuovi(mioUtente);

			// aggiungi ruolo
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(5L);
//			Ruolo mioRuolo=ruoloServiceInstance.caricaSingoloElemento(3L);
//			utenteServiceInstance.aggiungiRuolo(mioUtente, mioRuolo);

			// disassociare utente ruolo
//			Utente mioUtente = utenteServiceInstance.caricaSingoloElemento(2L);
//			Ruolo mioRuolo=ruoloServiceInstance.caricaSingoloElemento(2L);
//			utenteServiceInstance.disaccoppiaUtenteRuolo(mioUtente, mioRuolo);

//			**********METODI DI AUDIT**********

			// inserisci
//			Audit nuovoAudit = new Audit("cancellazione libro", CodiceEsitoOperazione.OK, "435", myDate,
//					utenteServiceInstance.caricaSingoloElemento(1L));
//			auditServiceInstance.inserisciNuovo(nuovoAudit);

			// list all
//			System.out.println(auditServiceInstance.listAll());

			// get
//			System.out.println(auditServiceInstance.caricaSingoloElemento(1L));

			// update
//			Audit mioAudit=auditServiceInstance.caricaSingoloElemento(1L);
//			mioAudit.setDescrizioneOperazione("sdfdsfsdf");
//			auditServiceInstance.aggiorna(mioAudit);

			// elimina
//			Audit mioAudit=auditServiceInstance.caricaSingoloElemento(1L);
//			auditServiceInstance.rimuovi(mioAudit);

//			*********METODI RICHIESTI*********

			// Tutti ruoli da utenti associati a un codice esito operazione
//			System.out.println(ruoloServiceInstance.tuttiRuoliDiUtentiAssociatiACodiceEsitoOperazione(CodiceEsitoOperazione.OK));

			// Tutte le password da utenti associati a un ruolo
//			Ruolo ruoloDa=ruoloServiceInstance.caricaSingoloElemento(1L);
//			System.out.println(ruoloServiceInstance.tutteLePasswordUtentiAssociatiAUnRuolo(ruoloDa));

			// Tutti gli audit associati a quel ruolo
//			Ruolo ruoloDa=ruoloServiceInstance.caricaSingoloElemento(1L);
//			System.out.println(auditServiceInstance.tuttiAssociatiAQuelRuolo(ruoloDa));
//		
//		

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

}
