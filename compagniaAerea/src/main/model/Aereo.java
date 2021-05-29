package main.model;

public class Aereo {
	
	private int id;
	private String modello;
	private int idStatoAereo;
	
	
	public Aereo(){
		
	}
	
	public Aereo(String modello) {
		this.modello=modello;
		this.idStatoAereo=1;
	}
	
	public Aereo(String modello, int stato) {
		this.modello=modello;
		try {
			
			this.setIdStatoAereo(stato);
			
		}catch(IllegalCallerException e) {
			e.printStackTrace();  //modificabile
		}
		
		
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Integer getIdStatoAereo() {
		return idStatoAereo;
	}
	public void setIdStatoAereo(Integer idStatoAereo) throws IllegalArgumentException {
		if(idStatoAereo<1 || idStatoAereo>3) {
			throw new IllegalArgumentException();
		}
		this.idStatoAereo = idStatoAereo;
	}
	@Override
	public String toString() {
		return "Aereo [id=" + id + ", modello=" + modello + ", idStatoAereo=" + idStatoAereo + "]";
	}
	
	
	
	
	
	

}
