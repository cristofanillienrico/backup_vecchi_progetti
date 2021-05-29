package it.prova.gestionegalleria.test;

import java.util.Calendar;
import java.util.Date;

import it.prova.gestionegalleria.dao.EntityManagerUtil;
import it.prova.gestionegalleria.model.Colore;
import it.prova.gestionegalleria.model.Galleria;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;
import it.prova.gestionegalleria.model.Tinta;
import it.prova.gestionegalleria.service.IGalleriaService;
import it.prova.gestionegalleria.service.IQuadroService;
import it.prova.gestionegalleria.service.IRestauratoreService;
import it.prova.gestionegalleria.service.ITintaService;
import it.prova.gestionegalleria.service.MyServiceFactory;

public class TestGestioneGalleria {

	public static void main(String[] args) {

		IGalleriaService galleriaService = MyServiceFactory.getGalleriaServiceInstance();
		IQuadroService quadroService = MyServiceFactory.getQuadroServiceInstance();
		ITintaService tintaService = MyServiceFactory.getTintaServiceInstance();
		IRestauratoreService restauratoreService = MyServiceFactory.getRestauratoreServiceInstance();

		// data accessoria
		Calendar calendario = Calendar.getInstance();
		calendario.set(1991, 11, 21);
		Date miaData = calendario.getTime();

		try {

//			**********GALLERIA**********

			// insert
//			Galleria nuovaGalleria = new Galleria("Louvre","Rue de Rivoli,Paris",miaData);
//			galleriaService.inserisciNuovo(nuovaGalleria);

//			get
//			System.out.println(galleriaService.caricaSingoloElemento(1L));

			// list all
//			System.out.println(galleriaService.listAll());

			// update
//			Galleria miaGalleria=galleriaService.caricaSingoloElemento(1L);
//			miaGalleria.setIndirizzo("modificato");
//			galleriaService.aggiorna(miaGalleria);

			// elimina senza quadro associato
//			Galleria miaGalleria=galleriaService.caricaSingoloElemento(1L);
//			galleriaService.rimuovi(miaGalleria);

			// elimina con quadro associato(lancia eccezione)
//			Galleria miaGalleria=galleriaService.caricaSingoloElemento(1L);
//			galleriaService.rimuovi(miaGalleria);

			// aggiungo quadro a galleria
//			galleriaService.aggiungiQuadro(galleriaService.caricaSingoloElemento(1L), new Quadro("Guernica","Picasso",miaData));

//			**********QUADRO**********

			// insert
//			Quadro nuovoQuadro=new Quadro("Muse Inquietanti","De Chirico",miaData);
//			quadroService.inserisciNuovo(nuovoQuadro);

			// get
//			System.out.println(quadroService.caricaSingoloElemento(1L));

			// get all
//			System.out.println(quadroService.listAll());

			// aggiorna
//			Quadro mioQuadro=quadroService.caricaSingoloElemento(1L);
//			mioQuadro.setAutore("Mangelli");
//			quadroService.aggiorna(mioQuadro);

			// aggiungi tinta
//			quadroService.aggiungiTinta(quadroService.caricaSingoloElemento(4L), tintaService.caricaSingoloElemento(1L));

			// aggiungi restauratore
//			quadroService.aggiungiRestauratore(quadroService.caricaSingoloElemento(5L), restauratoreService.caricaSingoloElemento(2L));

			// elimina
//			quadroService.rimuovi(quadroService.caricaSingoloElemento(3L));

			// elimina quadro collegato a tinta
//			quadroService.rimuovi(quadroService.caricaSingoloElemento(1L));

			// elimina quadro collegato a restauratore
//			quadroService.rimuovi(quadroService.caricaSingoloElemento(2L));

//			**********TINTA***********

			// insert
//			tintaService.inserisciNuovo(new Tinta("Blu Oltremare",Colore.BLU,100.0));

			// get
//			System.out.println(tintaService.caricaSingoloElemento(1L));

			// get all
//			System.out.println(tintaService.listAll());

			// update
//			Tinta miaTinta=tintaService.caricaSingoloElemento(1L);
//			miaTinta.setPrezzoUnitario(2323.0);
//			tintaService.aggiorna(miaTinta);

			// elimina tinta collegata a quadro
//			tintaService.rimuovi(tintaService.caricaSingoloElemento(1L));

//			**********RESTAURATORE**********

			// insert
//			restauratoreService.inserisciNuovo(new Restauratore("ugo", "muli", 1021.0));

			// get
//			System.out.println(restauratoreService.caricaSingoloElemento(1L));

			// get all
//			System.out.println(restauratoreService.listAll());

			// update
//			Restauratore miRestauratore=restauratoreService.caricaSingoloElemento(1L);
//			miRestauratore.setStipendio(2323.0);
//			restauratoreService.aggiorna(miRestauratore);

			// elimina restauratore collegato a quadro
//			restauratoreService.rimuovi(restauratoreService.caricaSingoloElemento(2L));

//			**********METODI RICHIESTI**********

			// lista indirizzi gallerie dove è stata usata una certa tinta
//			System.out.println(galleriaService.indirizziGallerieDoveUsataCertaTinta(tintaService.caricaSingoloElemento(2L)));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

}
