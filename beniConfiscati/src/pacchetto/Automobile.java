package pacchetto;

public class Automobile extends Bene {
	
	private int cilindrata;

	public Automobile(String telefono,int cilindrata) {
		super(telefono);
		this.cilindrata=cilindrata;
		setValore(cilindrata*10);
		
	}

}
