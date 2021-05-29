package it.prova.model;

public class Portatile extends Pezzo {
	
	
	private Long id;
	private Processore processore;
	private SchedaMadre schedaMadre;
	
	
	private Negozio negozio;
	
	
	
	
	
	
	
	
	
	public Portatile(Negozio negozio,String matricola, String modello, CasaProduttrice casaProduttrice) {
		super(matricola, modello, casaProduttrice);
		this.negozio=negozio;
		// TODO Auto-generated constructor stub
	}
	public Processore getProcessore() {
		return processore;
	}
	public void setProcessore(Processore processore) {
		this.processore = processore;
	}
	public SchedaMadre getSchedaMadre() {
		return schedaMadre;
	}
	public void setSchedaMadre(SchedaMadre schedaMadre) {
		this.schedaMadre = schedaMadre;
	}
	
	public Negozio getNegozio() {
		return negozio;
	}
	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}
	@Override
	public String toString() {
		return "Portatile [Matricola=" + getMatricola() + ", Modello=" + getModello() + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
