package it.prova.model;

import java.util.List;

public class SedeCentrale {

	private List<Negozio> listaNegozi;

	public SedeCentrale(List<Negozio> listaNegozi) {
		super();
		this.listaNegozi = listaNegozi;
	}

	public <T extends Pezzo> Negozio trovaNegozioDaPezzoDifettoso(T pezzoDifettoso) {

		if (pezzoDifettoso instanceof Portatile) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getMatricola().equals(pezzoDifettoso.getMatricola())) {
						return negozioItem;
					}
				}

			}

		} else if (pezzoDifettoso instanceof SchedaMadre) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getSchedaMadre().getMatricola().equals(pezzoDifettoso.getMatricola())) {
						return negozioItem;
					}
				}

			}

		} else if (pezzoDifettoso instanceof Processore) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getProcessore().getMatricola().equals(pezzoDifettoso.getMatricola())) {
						return negozioItem;
					}
				}

			}

		}

		return null;

	}

	public <T extends Pezzo> void stampaNegozioEPcDaPezzoDifettoso(T pezzoDifettoso) {

		if (pezzoDifettoso instanceof Portatile) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getMatricola().equals(pezzoDifettoso.getMatricola())) {

						System.out.println(negozioItem.toString() + portatileItem.toString());
					}
				}

			}

		} else if (pezzoDifettoso instanceof SchedaMadre) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getSchedaMadre().getMatricola().equals(pezzoDifettoso.getMatricola())) {
						System.out.println(negozioItem.toString() + portatileItem.toString());
					}
				}

			}

		} else if (pezzoDifettoso instanceof Processore) {
			for (Negozio negozioItem : listaNegozi) {
				for (Portatile portatileItem : negozioItem.getListaPortatili()) {
					if (portatileItem.getProcessore().getMatricola().equals(pezzoDifettoso.getMatricola())) {
						System.out.println(negozioItem.toString() + portatileItem.toString());
					}
				}

			}

		}

	}

	public List<Negozio> getListaNegozi() {
		return listaNegozi;
	}

	public void setListaNegozi(List<Negozio> listaNegozi) {
		this.listaNegozi = listaNegozi;
	}
	
}
