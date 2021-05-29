package pacchetto;

public class Appartamento extends Bene {
	
	private int metratura;
	
	

	public Appartamento(String telefono,int metratura) {
		super(telefono);
		this.metratura=metratura;
		setValore(metratura*1000);
		
	}
	
	

}
