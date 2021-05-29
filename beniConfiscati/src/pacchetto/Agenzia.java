package pacchetto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agenzia {
	
	private ArrayList <Bene> listaBeni=new ArrayList<>();
	private Rubrica rubrica=null;
	private HashMap<Beneficiario,Integer> registro= new HashMap<>();
	
	
	public Agenzia(Rubrica rubrica) {
		this.rubrica=rubrica;
	}
	
	public void riceviListaBeni(ArrayList <Bene> listaBeni) {
		this.listaBeni=listaBeni;
	}
	
	
	public  void consegnaDocumenti() {
		
		for(Bene bene : listaBeni ) {
			
			Beneficiario destinatario=rubrica.trovaBeneficiario(bene.getTelefono());
			Documento <Bene> documento=new Documento<>(destinatario,bene);
			destinatario.addDocumento(documento);
			destinatario.riceviBene(bene);
			
			if(!registro.containsKey(destinatario)) {
				
				registro.put(destinatario,bene.getValore());
				
			}else {
				
				registro.replace(destinatario,registro.get(destinatario)+bene.getValore());
			}
			
			
		}
	}
	
	
	
	
	public void termineAssegnazione() {
		
		Beneficiario maxB=null;
		Integer maxV=0;
		
		for (Map.Entry<Beneficiario,Integer> entry : registro.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			
			if(entry.getValue()>maxV) {
				maxV=entry.getValue();
				maxB=entry.getKey();
			}
        }
		
		
		System.out.println("Il beneficiario "+maxB.getNome()+" "+maxB.getRagioneSociale().toString().toLowerCase()+
				" situata in "+maxB.getIndirizzo()+" ha ricevuto i seguenti beni "+maxB.stringaListaBeni()+
				"\n Dal valore totale di "+maxV+"$");
		
		
		
		
	//		registro.forEach((k,v)-> {
//			
//			int max=0;
//			if(v>max){
//				max=v;
//			}
//			
//		
//		});
		
	}
	
	

}
