package it.prova.negozioreparto.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negozio")
public class Negozio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "ragione_sociale")
	private String ragioneSociale;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Enumerated(EnumType.STRING)
	@Column(name = "categoria")
	private Categoria categoria;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "negozio")
	private Set<Reparto> reparti = new HashSet<>();

	public Negozio() {
		super();
	}

	public Negozio(String ragioneSociale, String indirizzo, Categoria categoria) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Reparto> getReparti() {
		return reparti;
	}

	public void setReparti(Set<Reparto> reparti) {
		this.reparti = reparti;
	}

	@Override
	public String toString() {
		return "Negozio [id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo + ", categoria="
				+ categoria + "]";
	}

}
