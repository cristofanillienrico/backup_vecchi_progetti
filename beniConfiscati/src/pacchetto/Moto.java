package pacchetto;

public class Moto extends Bene {
	
	private int cilindrata;
	
	public Moto(String telefono,int cilindrata) {
		super(telefono);
		this.cilindrata=cilindrata;
		setValore(cilindrata*5);
	}

}
