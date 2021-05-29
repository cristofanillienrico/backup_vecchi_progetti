package esperimenti;

import java.util.Comparator;

public class Figlio extends Padre implements Interfaccia {
	
	private String nome;
	private String cognome;
	
	public Figlio() {
		nome="Jhon";
		cognome="Doe";
	}
	
	public Figlio(String nome, String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}

	
	
	
	

	
	
//	@Override
//	public String toString() {
//		return "Figlio [nome=" + nome + ", cognome=" + cognome + "]";
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public void metodoInterfaccia() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
