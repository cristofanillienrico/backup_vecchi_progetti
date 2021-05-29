package it.prova.model;

public class Processore extends PezzoInterno {
	
	private Long id;
	private int potenza;
	
	
	
	
	
	
	
	
	
	public Processore(int potenza,Portatile portatile, String matricola, String modello, CasaProduttrice casaProduttrice) {
		super(portatile, matricola, modello, casaProduttrice);
		this.potenza=potenza;
		
	}
	public int getPotenza() {
		return potenza;
	}
	public void setPotenza(int potenza) {
		this.potenza = potenza;
	}
	@Override
	public String toString() {
		return "Processore [potenza=" + potenza + ", Matricola=" + getMatricola() + ", Modello="
				+ getModello() + "]";
	}
	

	
	
	

}
