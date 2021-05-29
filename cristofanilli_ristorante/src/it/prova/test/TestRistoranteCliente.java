package it.prova.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.model.Ristorante;
import it.prova.service.MyServiceFactory;
import it.prova.service.cliente.IClienteService;
import it.prova.service.ristorante.IRistoranteService;

public class TestRistoranteCliente {

	public static void main(String[] args) {

		try {

			IRistoranteService ristoranteService = MyServiceFactory.getRistoranteServiceInstance();
			IClienteService clienteService = MyServiceFactory.getClienteServiceInstance();

			// Data accessoria
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String dateInString = "31-08-1982 10:20:56";
			Date dataProva = sdf.parse(dateInString);
//			 System.out.println(dataProva); //Tue Aug 31 10:20:56 SGT 1982

			// creo nuovo ristorante
//			Ristorante nuovoRistorante = new Ristorante("Star","via Dante,Napoli",3,dataProva,1);
//			// salvo
//			ristoranteService.inserisciNuovo(nuovoRistorante); //qui inserisce un id nel ristorante creato sopra
//			System.out.println("Municipio appena inserito: " + nuovoRistorante);
//			System.out.println(nuovoRistorante.getId());

			// creo nuovo cliente
//			Cliente nuovoCliente = new Cliente("Andrea","Vecchiato",120);
			// lo lego al ristorante appena inserito
//			nuovoCliente.setRistorante(nuovoRistorante);
			// salvo il nuovo abitante
//			clienteService.inserisciNuovo(nuovoCliente);
			//
//			// ricarico il ristorante per vederne gli aggiornamenti
//			// questa, durante la system.out che richiede i clienti, solleverebbe
//			// una LazyInitializationException in quanto il contesto di persistenza è chiuso
//			Ristorante ristoranteInstance = ristoranteService.caricaSingoloRistorante(nuovoRistorante.getId());
//			// allora usiamo un caricamento EAGER sovrascrivendo ristoranteInstance
//			ristoranteInstance = ristoranteService.caricaSingoloRistoranteConClienti(nuovoRistorante.getId());
//			System.out.println(ristoranteInstance.getId());

//			System.out
//					.println("Stampo gli abitanti del municipio appena ricaricato:" + ristoranteInstance.getClienti());
			//
//			System.out.println("########### RIMOZIONE CLIENTE ########################");
//			long idClienteEsistente = 6;
//			Cliente clienteEsistente2 = clienteService.caricaSingoloCliente(idClienteEsistente);
//			if (clienteEsistente2 != null) {
//				clienteService.rimuovi(clienteEsistente2);
//				//proviamo a vedere se è stato rimosso
//				clienteEsistente2 = clienteService.caricaSingoloCliente(idClienteEsistente);
//				if (clienteEsistente2 == null)
//					System.out.println("Cancellazione ok");
//				else
//					System.out.println("Cancellazione fallita!!!");
//				}else {
//					System.out.println("Non è presente nel database");
//					}
//			System.out.println("########### FINE RIMOZIONE CLIENTE ########################");
			//
//			 elencare i ristoranti
//			System.out.println("Elenco i ristoranti:");
//			for (Ristorante ristoranteItem : ristoranteService.listAllRistoranti()) {
//				System.out.println(ristoranteItem);
//				}
			//
			// elenca tutti i Clienti
//			System.out.println("Ecco i Clienti....");
//			for (Cliente abitanteItem : clienteService.listAllClienti()) {
//				 System.out.println(abitanteItem);
//				}

			// inserisco cliente in un ristorante pieno
//			Ristorante ristorantePieno = ristoranteService.caricaSingoloRistoranteConClienti(1L);
//			Cliente nuovoCliente = new Cliente("Andrea", "Vecchiato", 120);
//			nuovoCliente.setRistorante(ristorantePieno);
//			System.out.println(nuovoCliente.getRistorante().getNumeroCoperti());
//			clienteService.inserisciNuovo(nuovoCliente);

//			 faccio cambiare ristorante al cliente ma lo trova pieno
//			Cliente clienteCheCambiaRistorante =clienteService.caricaSingoloCliente(10L);
//			System.out.println(clienteCheCambiaRistorante);
//			clienteCheCambiaRistorante.setRistorante(ristoranteService.caricaSingoloRistoranteConClienti(1L));
//			clienteService.aggiorna(clienteCheCambiaRistorante);

			// rimozione del ristorante
//			Ristorante ristorantePieno = ristoranteService.caricaSingoloRistoranteConClienti(7L);
//			ristoranteService.rimuovi(ristorantePieno);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
