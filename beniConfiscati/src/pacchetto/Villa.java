package pacchetto;

public class Villa extends Appartamento {

	public Villa(String telefono, int metratura) {
		super(telefono, metratura);
		setValore(getValore()*2);
	}

}
