package it.prova.test;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.CasaProduttrice;
import it.prova.model.Negozio;
import it.prova.model.Portatile;
import it.prova.model.Processore;
import it.prova.model.SchedaMadre;
import it.prova.model.SedeCentrale;

public class Test {

	public static void main(String[] args) {

		// vado a raccogliere dei dati fittizi immaginado di averli ricevuti da un
		// database
		CasaProduttrice asus = new CasaProduttrice("Asus");
		Negozio viaRoma = new Negozio("via Roma");
		Portatile asusx510 = new Portatile(viaRoma, "33442342", "x510", asus);
		Processore ryzen9 = new Processore(1000, asusx510, "42432234", "Ryzen9", asus);
		SchedaMadre msi = new SchedaMadre(40, asusx510, "234242432", "msi22", asus);

		asusx510.setSchedaMadre(msi);
		asusx510.setProcessore(ryzen9);

		List listaPortatili = new ArrayList<Portatile>();
		listaPortatili.add(asusx510);
		viaRoma.setListaPortatili(listaPortatili);

		List listaSchedeMadri = new ArrayList<SchedaMadre>();
		List listaProcessori = new ArrayList<Processore>();
		listaSchedeMadri.add(msi);
		listaProcessori.add(ryzen9);
		asus.setListaPortatili(listaPortatili);
		asus.setListaProcessori(listaProcessori);
		asus.setListaSchedeMadri(listaSchedeMadri);

		// istanzio un oggetto SedeCentrale
		List listaNegozi = new ArrayList<Negozio>();
		listaNegozi.add(viaRoma);
		SedeCentrale miaSede = new SedeCentrale(listaNegozi);

		// eseguo i test
//		System.out.println(miaSede.trovaNegozioDaPezzoDifettoso(asusx510));
//		System.out.println(miaSede.trovaNegozioDaPezzoDifettoso(msi));
//		System.out.println(miaSede.trovaNegozioDaPezzoDifettoso(ryzen9));

		miaSede.stampaNegozioEPcDaPezzoDifettoso(asusx510);
		miaSede.stampaNegozioEPcDaPezzoDifettoso(msi);
		miaSede.stampaNegozioEPcDaPezzoDifettoso(ryzen9);

	}

}
