package main.model;



public class Dipendenti {
	private int id;
	private String nome;
	private String cognome;
	

	
	public Dipendenti() {
		
	}
	
	public Dipendenti(String nome,String cognome) {
		this.nome=nome;
		this.cognome=cognome;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d %s %s",id,nome,cognome);
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

}
