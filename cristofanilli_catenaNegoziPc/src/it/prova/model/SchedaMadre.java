package it.prova.model;

public class SchedaMadre extends PezzoInterno {
	
	private Long id;
	private int grandezza ;

	
	
	
	
	public SchedaMadre(int grandezza,Portatile portatile, String matricola, String modello, CasaProduttrice casaProduttrice) {
		super(portatile, matricola, modello, casaProduttrice);
		this.grandezza=grandezza;
	}

	public int getGrandezza() {
		return grandezza;
	}

	public void setGrandezza(int grandezza) {
		this.grandezza = grandezza;
	}

	@Override
	public String toString() {
		return "SchedaMadre [grandezza=" + grandezza + ", Matricola=" + getMatricola() + ", Modello="
				+ getModello() + "]";
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

}
