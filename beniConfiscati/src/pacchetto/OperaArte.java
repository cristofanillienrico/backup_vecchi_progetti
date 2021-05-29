package pacchetto;

public class OperaArte extends Bene {
	
	private String nome;
	private String autore;
	private int data;

	public OperaArte(String telefono,String nome, String autore, int data) {
		super(telefono);
		this.nome=nome;
		this.autore=autore;
		this.data=data;
		setValore(10000-data);
	}

}
