package model;

public class Cd {
	
	private Long id;
	private String titolo;
	private String genere;
	private int numeroTracce;
	private Autore autore;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Cd() {
		super();
	}
	public Cd(String titolo, String genere, int numeroTracce, Autore autore) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.numeroTracce = numeroTracce;
		this.autore = autore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getNumeroTracce() {
		return numeroTracce;
	}
	public void setNumeroTracce(int numeroTracce) {
		this.numeroTracce = numeroTracce;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	@Override
	public String toString() {
		return "Cd [id=" + id + ", titolo=" + titolo + ", genere=" + genere + ", numeroTracce=" + numeroTracce
				+ ", autore=" + autore + "]";
	}
	
	
	
	
	
	

}
