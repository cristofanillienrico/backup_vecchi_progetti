package it.prova.negozioreparto.test;

import it.prova.negozioreparto.dao.EntityManagerUtil;
import it.prova.negozioreparto.model.Categoria;
import it.prova.negozioreparto.model.Negozio;
import it.prova.negozioreparto.service.IAddettoService;
import it.prova.negozioreparto.service.INegozioService;
import it.prova.negozioreparto.service.IRepartoService;
import it.prova.negozioreparto.service.MyServiceFactory;

public class TestNegozioReaparto {

	public static void main(String[] args) {
		try {

			INegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
			IRepartoService repartoService = MyServiceFactory.getRepartoServiceInstance();
			IAddettoService addettoService = MyServiceFactory.getAddettoServiceInstance();

//			**********TESTO LE CRUD**********

//			**********NEGOZIO**********

			// insert
			Negozio nuovoNegozio= new Negozio("Pam","via Moravia,Roma",Categoria.C1);
			negozioService.inserisciNuovo(nuovoNegozio);

			// get
//			System.out.println(negozioService.caricaSingoloElemento(2L));

			// get all
//			System.out.println(negozioService.listAll());

			// update
//			Negozio mioNegozio=negozioService.caricaSingoloElemento(2L);
//			mioNegozio.setRagioneSociale("modificato");
//			negozioService.aggiorna(mioNegozio);

			// trova tutti reparti da negozio
//			System.out.println(negozioService.tuttiRepartiDatoUnNegozio(negozioService.caricaSingoloElemento(2L)));

			// elimina negozio senza reparti
//			negozioService.rimuovi(negozioService.caricaSingoloElemento(3L));

			// elimina con reparti(deve lanciare eccezione)
//			negozioService.rimuovi(negozioService.caricaSingoloElemento(2L));

//			**********REPARTO**********

			// insert
//			Reparto nuovoReparto=new Reparto("ortofrutta",1,negozioService.caricaSingoloElemento(1L));
//			repartoService.aggiorna(nuovoReparto);

			// aggiungi un addetto
//			Reparto mioReparto=repartoService.caricaSingoloElemento(3L);
//			Addetto nuovoAddetto=new Addetto("Cosimo","Polito",1000.0);
//			repartoService.aggiungiAddetto(mioReparto, nuovoAddetto);

			// get
//			System.out.println(repartoService.caricaSingoloElemento(1L));

			// get all
//			System.out.println(repartoService.listAll());

			// update
//			Reparto mioReparto=repartoService.caricaSingoloElemento(1L);
//			mioReparto.setDescrizione("modificato");
//			repartoService.aggiorna(mioReparto);

			// rimuovi reparto senza addetti
//			repartoService.rimuovi(repartoService.caricaSingoloElemento(1L));

			// rimuovi reparto con addetti
//			repartoService.rimuovi(repartoService.caricaSingoloElemento(2L));

//			**********ADDETTO**********

			// insert
//			Addetto nuovoAddetto=new Addetto("Giacomo","DiBiagio",1000.0);
//			addettoService.inserisciNuovo(nuovoAddetto);

			// get
//			System.out.println(addettoService.caricaSingoloElemento(1L));

			// get all
//			System.out.println(addettoService.listAll());

			// update
//			Addetto mioAddetto=addettoService.caricaSingoloElemento(1L);
//			mioAddetto.setCognome("modificato");
//			addettoService.aggiorna(mioAddetto);

			// rimuovi addetto senza reparto
//			addettoService.rimuovi(addettoService.caricaSingoloElemento(1L));

			// rimuovi addetto con reparto
//			addettoService.rimuovi(addettoService.caricaSingoloElemento(6L));

//			**********METODI RICHIESTI **********

			// lista dei negozi che hanno un addetto con un determinato cognome
//			System.out.println(negozioService.listaNegoziConAddettoConDeterminatoCognome("Polito"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

}
