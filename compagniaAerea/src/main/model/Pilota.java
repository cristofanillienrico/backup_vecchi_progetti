package main.model;

public class Pilota {
	
	private Integer id;
	private String nome;
	private String cognome;
	private Integer stipendio;
	private Integer idStatoPilota;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Pilota( String nome, String cognome, Integer stipendio, Integer idStatoPilota) {
		super();
		
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
		this.idStatoPilota = idStatoPilota;
	}
	public Pilota() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getStipendio() {
		return stipendio;
	}
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	public int getIdStatoPilota() {
		return idStatoPilota;
	}
	public void setIdStatoPilota(int idStatoPilota) {
		this.idStatoPilota = idStatoPilota;
	}
	@Override
	public String toString() {
		return "Pilota [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", stipendio=" + stipendio
				+ ", idStatoPilota=" + idStatoPilota + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
