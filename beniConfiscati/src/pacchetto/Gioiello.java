package pacchetto;

public class Gioiello extends Bene {
	
	private int carati;

	public Gioiello(String telefono, int carati) {
		super(telefono);
		this.carati=carati;
		setValore(carati*1000);
		
	}

}
