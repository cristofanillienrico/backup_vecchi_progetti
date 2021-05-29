package it.prova.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ristorante")
public class Ristorante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "ragione_sociale")
	private String ragioneSociale;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "numero_stelle")
	private Integer numeroStelle;

	@Column(name = "data_apertura")
	private Date dataApertura;

	@Column(name = "numero_coperti")
	private Integer numeroCoperti;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ristorante")
	private Set<Cliente> clienti = new HashSet<>();

	public Ristorante() {
		super();
	}

	public Ristorante(String ragioneSociale, String indirizzo, Integer numeroStelle, Date dataApertura,
			Integer numeroCoperti) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.numeroStelle = numeroStelle;
		this.dataApertura = dataApertura;
		this.numeroCoperti = numeroCoperti;
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

	public Integer getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(Integer numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public Integer getNumeroCoperti() {
		return numeroCoperti;
	}

	public void setNumeroCoperti(Integer numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}

	public Set<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(Set<Cliente> clienti) {
		this.clienti = clienti;
	}

	@Override
	public String toString() {
		return "Ristorante [id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo
				+ ", numeroStelle=" + numeroStelle + ", dataApertura=" + dataApertura + ", numeroCoperti="
				+ numeroCoperti +"]";
	}

}
