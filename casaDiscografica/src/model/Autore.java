package model;

import java.util.Date;
import java.util.List;

public class Autore {
	private Long id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String nickname;
	private CasaDiscografica casaDiscografica;
	private List<Cd> listaCd;
	
	
	
	
	
	
	
	
	
	
	public Autore(Long id, String nome, String cognome, Date dataNascita, String nickname) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nickname = nickname;
	}
	public Autore(Long id, String nome, String cognome, Date dataNascita, String nickname,
			CasaDiscografica casaDiscografica) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nickname = nickname;
		this.casaDiscografica = casaDiscografica;
	}
	public Autore(String nome, String cognome, Date dataNascita, String nickname,
			CasaDiscografica casaDiscografica) {
		super();
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nickname = nickname;
		this.casaDiscografica = casaDiscografica;
	}
	public Autore() {
		super();
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public CasaDiscografica getCasaDiscografica() {
		return casaDiscografica;
	}
	public void setCasaDiscografica(CasaDiscografica casaDiscografica) {
		this.casaDiscografica = casaDiscografica;
	}
	public List<Cd> getListaCd() {
		return listaCd;
	}
	public void setListaCd(List<Cd> listaCd) {
		this.listaCd = listaCd;
	}
	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", nickname=" + nickname + ", casaDiscografica=" + casaDiscografica + ", listaCd=" + listaCd + "]";
	}
	
	
	
	
	

}
