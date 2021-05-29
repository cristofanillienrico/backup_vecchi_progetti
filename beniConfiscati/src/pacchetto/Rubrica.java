package pacchetto;

import java.util.HashMap;

public class Rubrica {
	
	private HashMap <String,Beneficiario> mappa = new HashMap<>();
	
	
	public void addBeneficiario(Beneficiario b) {
		
		String tel=b.getTelefono();
		mappa.put(tel, b);
		
	}
	
	public Beneficiario trovaBeneficiario(String telefono) {
		
		return mappa.get(telefono);
		
	}

}
