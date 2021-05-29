package it.prova.model;

import java.util.Date;
import java.util.List;

public class CompagniaAssicurativa {
	
	private Long id;
	private String ragioneSociale;
	private Date dataFondazione;
	private String indirizzo;
	
	private List<Automobile> listaAutomobili;
	
	
	
	
	
	
	
	
	
	
	
	
	public CompagniaAssicurativa() {
		super();
	}

	public CompagniaAssicurativa(String ragioneSociale, Date dataFondazione, String indirizzo) {
		super();
	
		this.ragioneSociale = ragioneSociale;
		this.dataFondazione = dataFondazione;
		this.indirizzo = indirizzo;
	}

	public Long getId() {
		return id;
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public Date getDataFondazione() {
		return dataFondazione;
	}
	public void setDataFondazione(Date dataFondazione) {
		this.dataFondazione = dataFondazione;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public List<Automobile> getListaAutomobili() {
		return listaAutomobili;
	}
	public void setListaAutomobili(List<Automobile> listaAutomobili) {
		this.listaAutomobili = listaAutomobili;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CompagniaAssicurativa [id=" + id + ", ragioneSociale=" + ragioneSociale + ", dataFondazione="
				+ dataFondazione + ", indirizzo=" + indirizzo + ", listaAutomobili=" + listaAutomobili + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
