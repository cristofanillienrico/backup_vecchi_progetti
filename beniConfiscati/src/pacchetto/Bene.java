package pacchetto;

public abstract class Bene {
	
	private String telefono=""; 
	private int valore=0;


	
	
	
	
	
	public Bene(String telefono) {
		try {
			if(telefono.length()!=9) {
				throw new Exception();
			}
		}catch (Exception e){
			
			System.out.println("Inserisci numero di telefono corretto!");
			
		}
		this.telefono=telefono;
	}
	
	
	
	public String stringa() {
		return this.getClass().getSimpleName();
	}
	
	
	
	
	
	
	
	public String getTelefono() {
		return telefono;
	}
	
	public int getValore() {
		return valore;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setValore(int valore) {
		this.valore = valore;
	}
	
	

}
