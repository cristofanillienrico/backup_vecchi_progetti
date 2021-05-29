package main.model;

public class Biglietto {
	
	private int id;
	private int prezzo;
	private int idPasseggero;
	private int idVolo;
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public int getIdPasseggero() {
		return idPasseggero;
	}
	public void setIdPasseggero(int idPasseggero) {
		this.idPasseggero = idPasseggero;
	}
	public int getIdVolo() {
		return idVolo;
	}
	public void setIdVolo(int idVolo) {
		this.idVolo = idVolo;
	}
	@Override
	public String toString() {
		return "Biglietto [id=" + id + ", prezzo=" + prezzo + ", idPasseggero=" + idPasseggero + ", idVolo=" + idVolo
				+ "]";
	}
	
	
	
	
	
	
	

}
