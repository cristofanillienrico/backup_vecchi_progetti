package it.prova.model;

import java.util.Date;
import java.util.List;

public class Proprietario {
	
	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	
	private List<Automobile> listaAutomobili;

	
	
	
	
	
	
	
	
	public Proprietario() {
		super();
	}

	public Proprietario(String nome, String cognome, Date dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public List<Automobile> getListaAutomobili() {
		return listaAutomobili;
	}

	public void setListaAutomobili(List<Automobile> listaAutomobili) {
		this.listaAutomobili = listaAutomobili;
	}

	@Override
	public String toString() {
		return "Proprietario [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", listaAutomobili=" + listaAutomobili + "]";
	}
	
	
	
	
	
	
	
	

}
