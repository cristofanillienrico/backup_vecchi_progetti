package it.prova.model;

import java.util.Date;

public class Automobile {
	
	private Long id;
	private String marca;
	private String modello;
	private int cilindrata;
	private Date dataImmatricolazione;
	
	private CompagniaAssicurativa compagniaAssicurativa;
	private Proprietario proprietario;
	
	
	
	
	
	
	
	
	
	
	public Automobile() {
		super();
	}
	public Automobile(String marca, String modello, int cilindrata, Date dataImmatricolazione,
			CompagniaAssicurativa compagniaAssicurativa, Proprietario proprietario) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.dataImmatricolazione = dataImmatricolazione;
		this.compagniaAssicurativa = compagniaAssicurativa;
		this.proprietario = proprietario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public Date getDataImmatricolazione() {
		return dataImmatricolazione;
	}
	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}
	public CompagniaAssicurativa getCompagniaAssicurativa() {
		return compagniaAssicurativa;
	}
	public void setCompagniaAssicurativa(CompagniaAssicurativa compagniaAssicurativa) {
		this.compagniaAssicurativa = compagniaAssicurativa;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata
				+ ", dataImmatricolazione=" + dataImmatricolazione + ", compagniaAssicurativa=" + compagniaAssicurativa
				+ ", proprietario=" + proprietario + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
