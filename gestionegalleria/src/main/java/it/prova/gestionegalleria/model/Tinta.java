package it.prova.gestionegalleria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tinta")
public class Tinta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome_pigmento")
	private String nomePigmento;

	@Enumerated(EnumType.STRING)
	@Column(name = "colore")
	private Colore colore;

	@Column(name = "prezzo_unitario")
	private Double prezzoUnitario;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tinte")
	private Set<Quadro> quadri = new HashSet<>();

	public Tinta() {
		super();
	}

	public Tinta(String nomePigmento, Colore colore, Double prezzoUnitario) {
		super();
		this.nomePigmento = nomePigmento;
		this.colore = colore;
		this.prezzoUnitario = prezzoUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePigmento() {
		return nomePigmento;
	}

	public void setNomePigmento(String nomePigmento) {
		this.nomePigmento = nomePigmento;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public Set<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(Set<Quadro> quadri) {
		this.quadri = quadri;
	}

	@Override
	public String toString() {
		return "Tinta [id=" + id + ", nomePigmento=" + nomePigmento + ", colore=" + colore + ", prezzoUnitario="
				+ prezzoUnitario + "]";
	}

}
