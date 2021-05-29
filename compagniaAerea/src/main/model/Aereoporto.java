package main.model;

public class Aereoporto {
	
	private int id;
	private String citta;
	
	
	
	
	
	
	
	
	
	
	public Aereoporto() {
		super();
	}
	public Aereoporto(String citta) {
		super();
		this.citta = citta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	@Override
	public String toString() {
		return "Aereoporto [id=" + id + ", citta=" + citta + "]";
	}
	
	
	
	
	
	

}
