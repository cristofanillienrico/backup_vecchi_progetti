package it.prova.model;

import java.util.List;

public class Negozio {
	
	private Long id;
	private String indirizzo;
	private List<Portatile> listaPortatili;
	
	
	
	
	
	
	
	
	
	public Negozio(String indirizzo) {
		super();
		this.indirizzo = indirizzo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public List<Portatile> getListaPortatili() {
		return listaPortatili;
	}
	public void setListaPortatili(List<Portatile> listaPortatili) {
		this.listaPortatili = listaPortatili;
	}
	@Override
	public String toString() {
		return "Negozio [indirizzo=" + indirizzo +  "]";
	}
	
	
	
	

}
