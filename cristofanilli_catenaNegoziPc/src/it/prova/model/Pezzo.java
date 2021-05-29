package it.prova.model;

public abstract class Pezzo {
	
	private String matricola;
	private String modello;
	private CasaProduttrice casaProduttrice;

	
	
	
	
	
	
	
	public Pezzo() {
		super();
	}

	public Pezzo(String matricola, String modello, CasaProduttrice casaProduttrice) {
		super();
		this.matricola = matricola;
		this.modello = modello;
		this.casaProduttrice = casaProduttrice;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public CasaProduttrice getCasaProduttrice() {
		return casaProduttrice;
	}

	public void setCasaProduttrice(CasaProduttrice casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}
	
	
	
	
	
	
	
	
}
