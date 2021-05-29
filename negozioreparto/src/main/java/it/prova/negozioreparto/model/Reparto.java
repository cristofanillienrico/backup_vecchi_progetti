package it.prova.negozioreparto.model;

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
@Table(name = "reparto")
public class Reparto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "numero")
	private Integer numero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "negozio_id")
	private Negozio negozio;

	@ManyToMany
	@JoinTable(name = "reparto_addetto", joinColumns = @JoinColumn(name = "reparto_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "addetto_id", referencedColumnName = "ID"))
	private Set<Addetto> addetti = new HashSet<>(0);

	public Reparto() {
		super();
	}

	public Reparto(String descrizione, Integer numero, Negozio negozio) {
		super();
		this.descrizione = descrizione;
		this.numero = numero;
		this.negozio = negozio;
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	public Set<Addetto> getAddetti() {
		return addetti;
	}

	public void setAddetti(Set<Addetto> addetti) {
		this.addetti = addetti;
	}

	@Override
	public String toString() {
		return "Reparto [id=" + id + ", descrizione=" + descrizione + ", numero=" + numero + "]";
	}

}
