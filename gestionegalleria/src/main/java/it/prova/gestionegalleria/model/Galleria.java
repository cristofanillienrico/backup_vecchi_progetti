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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "galleria")
public class Galleria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "data_fondazione")
	private Date dataFondazione;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "galleria")
	private Set<Quadro> quadri = new HashSet<>();

	public Galleria() {
		super();
	}

	public Galleria(String nome, String indirizzo, Date dataFondazione) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.dataFondazione = dataFondazione;
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

	public Set<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(Set<Quadro> quadri) {
		this.quadri = quadri;
	}

	@Override
	public String toString() {
		return "Galleria [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", dataFondazione="
				+ dataFondazione + "]";
	}

}
