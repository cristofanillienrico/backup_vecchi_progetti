package model;

import java.util.Date;
import java.util.List;

public class CasaDiscografica {
	private Long id;
	private String ragioneSociale;
	private String indirizzo;
	private Date dataFondazione;
	private List<Autore> listaAutori;
	
	
	
	
	
	
	
	
	
	public CasaDiscografica(Long id, String ragioneSociale, String indirizzo, Date dataFondazione) {
		super();
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.dataFondazione = dataFondazione;
	}



	public CasaDiscografica(String ragioneSociale, String indirizzo, Date dataFondazione) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.dataFondazione = dataFondazione;
	}



	public CasaDiscografica() {
		super();
	}

	

	public List<Autore> getListaAutori() {
		return listaAutori;
	}



	public void setListaAutori(List<Autore> listaAutori) {
		this.listaAutori = listaAutori;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(Date dataFondazione) {
		this.dataFondazione = dataFondazione;
	}



	@Override
	public String toString() {
		return "CasaDiscografica [id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo
				+ ", dataFondazione=" + dataFondazione + ", listaAutori=" + listaAutori + "]";
	}

	
	
	
	
	
	
	
	
}
