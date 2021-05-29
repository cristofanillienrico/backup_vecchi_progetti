package it.prova.ordinearticolo.test;

import it.prova.ordinearticolo.dao.EntityManagerUtil;
import it.prova.ordinearticolo.model.Articolo;
import it.prova.ordinearticolo.model.Categoria;
import it.prova.ordinearticolo.model.Ordine;
import it.prova.ordinearticolo.service.IArticoloService;
import it.prova.ordinearticolo.service.ICategoriaService;
import it.prova.ordinearticolo.service.IOrdineService;
import it.prova.ordinearticolo.service.MyServiceFactory;

public class TestOrdineArticolo {

	public static void main(String[] args) {

		IArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		ICategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		IOrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

		try {
			// ##################TEST#################

			// ORDINE

			// inserisci ordine
//			Ordine nuovoOrdine=new Ordine("Giovanni","Via Mosca,Roma");
//			ordineServiceInstance.inserisciNuovo(nuovoOrdine);

			// lista di tutti gli ordini
//			System.out.println(ordineServiceInstance.listAll());

			// get ordine
//			System.out.println(ordineServiceInstance.caricaSingoloElemento(1L));

			// update ordine
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(1L);
//			ordineProva.setIndirizzoSpedizione("modificato");
//			ordineServiceInstance.aggiorna(ordineProva);

			// delete ordine con articoli
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(2L);
//			ordineServiceInstance.rimuovi(ordineProva);

			// delete ordine senza articoli
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(1L);
//		    ordineServiceInstance.rimuovi(ordineProva);

			// ARTICOLO

			// insert articolo
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(2L);
//          Articolo nuovoArticolo=new Articolo("lavatrice", 1000d, ordineProva );
//			articoloServiceInstance.inserisciNuovo(nuovoArticolo);

			// get all
//			System.out.println(articoloServiceInstance.listAll());

			// get
//			System.out.println(articoloServiceInstance.caricaSingoloElemento(1L));

			// update
//			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(1L);
//			articoloProva.setDescrizione("modificato");
//			articoloServiceInstance.aggiorna(articoloProva);

			// trova tutti da ordine
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(2L);
//			System.out.println(articoloServiceInstance.trovaTuttiDaOrdine(ordineProva));

			// aggiungi categoria ad articolo
//			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(2L);
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(1L);
//			articoloServiceInstance.aggiungiCategoria(articoloProva, nuovaCategoria);

			// dissocia articolo categoria
//			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(1L);
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(1L);
//			articoloServiceInstance.disassociaArticoloCategoria(articoloProva, nuovaCategoria);

			// delete
//			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(1L);
//			articoloServiceInstance.rimuovi(articoloProva);

			// CATEGORIA

			// insert
//			Categoria nuovaCategoria=new Categoria("elettrodomestici");
//			categoriaServiceInstance.inserisciNuovo(nuovaCategoria);

			// get
//			System.out.println(categoriaServiceInstance.caricaSingoloElemento(1L));

			// get all
//			System.out.println(categoriaServiceInstance.listAll());

			// update
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(1L);
//			nuovaCategoria.setDescrizione("modificato");
//			categoriaServiceInstance.aggiorna(nuovaCategoria);

			// delete
			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(1L);
			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(2L);
			categoriaServiceInstance.rimuovi(nuovaCategoria);

			// disassocia categoria da articolo
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(1L);
//			Articolo articoloProva=articoloServiceInstance.caricaSingoloElemento(2L);
//			categoriaServiceInstance.disassociaCategoriaArticolo(nuovaCategoria, articoloProva);

//			METODI

			// tutti ordini da categoria
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(2L);
//			System.out.println(ordineServiceInstance.tuttiOrdiniDataUnaCategoria(nuovaCategoria));

			// tutte categorie da articoli di un ordine
//			Ordine ordineProva=ordineServiceInstance.caricaSingoloElemento(2L);
//			System.out.println(categoriaServiceInstance.tutteCategorieDegliArticoliDiUnOridine(ordineProva));

			// somma prezzi degli articoli legati ad una categoria
//			Categoria nuovaCategoria=categoriaServiceInstance.caricaSingoloElemento(2L);
//			System.out.println(articoloServiceInstance.sommaPrezziArticoliDiUnaCategoria(nuovaCategoria));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			EntityManagerUtil.shutdown();

		}
	}

}
