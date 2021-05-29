package it.prova.negozioreparto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "addetto")

public class Addetto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "stipendio")
	private Double stipendio;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "addetti")
	private Set<Reparto> reparti = new HashSet<>();

	public Addetto() {
		super();
	}

	public Addetto(String nome, String cognome, Double stipendio) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Double getStipendio() {
		return stipendio;
	}

	public void setStipendio(Double stipendio) {
		this.stipendio = stipendio;
	}

	public Set<Reparto> getReparti() {
		return reparti;
	}

	public void setReparti(Set<Reparto> reparti) {
		this.reparti = reparti;
	}

	@Override
	public String toString() {
		return "Addetto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", stipendio=" + stipendio + "]";
	}

}
