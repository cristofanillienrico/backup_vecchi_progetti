package it.prova.model;

public abstract class PezzoInterno extends Pezzo {
	
	private Portatile portatile;
	
	
	
	
	
	
	
	public PezzoInterno(Portatile portatile,String matricola, String modello, CasaProduttrice casaProduttrice) {
		super(matricola, modello, casaProduttrice);
		this.portatile=portatile;
		
	}
	public Portatile getPortatile() {
		return portatile;
	}
	public void setPortatile(Portatile portatile) {
		this.portatile = portatile;
	}

	
	
	
	
	
	
	

}
