package main.model;

import java.util.Date;

public class Volo {
	
	
	private int id;
	private Date orarioPartenza;
	private Date orarioArrivo;
	private Date giornoVolo;
	private int aereoId;
	private int pilotaId;
	private int aereoportoPartenzaId;
	private int aereoportoArrivoId;
	private boolean annullato;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Volo() {
		super();
	}
	public Volo(Date orarioPartenza, Date orarioArrivo, Date giornoVolo, int aereoId, int pilotaId,
			int aereoportoPartenzaId, int aereoportoArrivoId) {
		super();
		
		this.orarioPartenza = orarioPartenza;
		this.orarioArrivo = orarioArrivo;
		this.giornoVolo = giornoVolo;
		this.aereoId = aereoId;
		this.pilotaId = pilotaId;
		this.aereoportoPartenzaId = aereoportoPartenzaId;
		this.aereoportoArrivoId = aereoportoArrivoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrarioPartenza() {
		return orarioPartenza;
	}
	public void setOrarioPartenza(Date orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}
	public Date getOrarioArrivo() {
		return orarioArrivo;
	}
	public void setOrarioArrivo(Date orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}
	public Date getGiornoVolo() {
		return giornoVolo;
	}
	public void setGiornoVolo(Date giornoVolo) {
		this.giornoVolo = giornoVolo;
	}
	public int getAereoId() {
		return aereoId;
	}
	public void setAereoId(int aereoId) {
		this.aereoId = aereoId;
	}
	public int getPilotaId() {
		return pilotaId;
	}
	public void setPilotaId(int pilotaId) {
		this.pilotaId = pilotaId;
	}
	public int getAereoportoPartenzaId() {
		return aereoportoPartenzaId;
	}
	public void setAereoportoPartenzaId(int aereoportoPartenzaId) {
		this.aereoportoPartenzaId = aereoportoPartenzaId;
	}
	public int getAereoportoArrivoId() {
		return aereoportoArrivoId;
	}
	public void setAereoportoArrivoId(int aereoportoArrivoId) {
		this.aereoportoArrivoId = aereoportoArrivoId;
	}
	@Override
	public String toString() {
		return "Volo [id=" + id + ", orarioPartenza=" + orarioPartenza + ", orarioArrivo=" + orarioArrivo
				+ ", giornoVolo=" + giornoVolo + ", aereoId=" + aereoId + ", pilotaId=" + pilotaId
				+ ", aereoportoPartenzaId=" + aereoportoPartenzaId + ", aereoportoArrivoId=" + aereoportoArrivoId
				+ ", annullato=" + annullato + "]";
	}
	
	public boolean isAnnullato() {
		return annullato;
	}
	public void setAnnullato(boolean annullato) {
		this.annullato = annullato;
	}
	
	
	
	
	
	
	
	
	

}
