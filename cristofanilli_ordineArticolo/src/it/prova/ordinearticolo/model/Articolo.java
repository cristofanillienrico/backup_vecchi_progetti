package it.prova.ordinearticolo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "prezzo_unitario")
	private Double prezzoUnitario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;

	@ManyToMany
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<>(0);

	public Articolo() {
		super();
	}

	public Articolo(String descrizione, Double prezzoUnitario, Ordine ordine) {
		super();
		this.descrizione = descrizione;
		this.prezzoUnitario = prezzoUnitario;
		this.ordine = ordine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", prezzoUnitario=" + prezzoUnitario + "]";
	}
	
	
	

}
