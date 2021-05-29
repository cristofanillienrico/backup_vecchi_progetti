package it.prova.model;

import java.util.List;

public class CasaProduttrice {
	
	private Long id;
	private String nome;
	
	private List<Portatile> listaPortatili;
	private List<Processore> listaProcessori;
	private List<SchedaMadre> listaSchedeMadri;
	
	
	
	
	
	
	
	
	
	public CasaProduttrice(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Portatile> getListaPortatili() {
		return listaPortatili;
	}
	public void setListaPortatili(List<Portatile> listaPortatili) {
		this.listaPortatili = listaPortatili;
	}
	public List<Processore> getListaProcessori() {
		return listaProcessori;
	}
	public void setListaProcessori(List<Processore> listaProcessori) {
		this.listaProcessori = listaProcessori;
	}
	public List<SchedaMadre> getListaSchedeMadri() {
		return listaSchedeMadri;
	}
	public void setListaSchedeMadri(List<SchedaMadre> listaSchedeMadri) {
		this.listaSchedeMadri = listaSchedeMadri;
	}
	@Override
	public String toString() {
		return "CasaProduttrice [nome=" + nome + ", listaPortatili=" + listaPortatili + ", listaProcessori="
				+ listaProcessori + ", listaSchedeMadri=" + listaSchedeMadri + "]";
	}
	
	
	
	
	
	

}
