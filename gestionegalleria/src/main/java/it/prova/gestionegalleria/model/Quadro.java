package it.prova.gestionegalleria.model;

import java.util.Date;
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
@Table(name = "quadro")
public class Quadro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "autore")
	private String autore;

	@Column(name = "data_esecuzione")
	private Date dataEsecuzione;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "galleria_id")
	private Galleria galleria;

	@ManyToMany
	@JoinTable(name = "quadro_tinta", joinColumns = @JoinColumn(name = "quadro_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "tinta_id", referencedColumnName = "ID"))
	private Set<Tinta> tinte = new HashSet<>(0);

	@ManyToMany
	@JoinTable(name = "quadro_restauratore", joinColumns = @JoinColumn(name = "quadro_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "restauratore_id", referencedColumnName = "ID"))
	private Set<Restauratore> restauratori = new HashSet<>(0);

	public Quadro() {
		super();
	}

	public Quadro(String titolo, String autore, Date dataEsecuzione) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.dataEsecuzione = dataEsecuzione;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
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

	public Date getDataEsecuzione() {
		return dataEsecuzione;
	}

	public void setDataEsecuzione(Date dataEsecuzione) {
		this.dataEsecuzione = dataEsecuzione;
	}

	public Galleria getGalleria() {
		return galleria;
	}

	public void setGalleria(Galleria galleria) {
		this.galleria = galleria;
	}

	public Set<Tinta> getTinte() {
		return tinte;
	}

	public void setTinte(Set<Tinta> tinte) {
		this.tinte = tinte;
	}

	public Set<Restauratore> getRestauratori() {
		return restauratori;
	}

	public void setRestauratori(Set<Restauratore> restauratori) {
		this.restauratori = restauratori;
	}

	@Override
	public String toString() {
		return "Quadro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", dataEsecuzione=" + dataEsecuzione
				+ "]";
	}

}
