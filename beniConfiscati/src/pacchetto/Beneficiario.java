package pacchetto;

import java.util.ArrayList;

public class Beneficiario {
	
	private String nome="";
	private String telefono="";
	private RagioneSociale ragioneSociale;
	private String indirizzo="";
	private String mail="";
	private ArrayList<Documento<Bene>> documenti=new ArrayList<>();
	private ArrayList<Bene> beniRicevuti= new ArrayList<>();
	private Tipo tipo;
	
	
	
	
	public enum Tipo{
		NOPROFIT,
		ENTI,
		MUSEI,
		RICERCA
	}
	
	
	
	
	//068123456
	public Beneficiario(String nome,Tipo tipo , RagioneSociale ragioneSociale,String telefono, String indirizzo) {
		
		try {
			if(telefono.length()!=9) {
				throw new Exception();
			}
		}catch (Exception e){
			
			System.out.println("Inserisci numero di telefono corretto!");
			
		}
	
		this.nome = nome;
		this.telefono = telefono;
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.mail=nome.toLowerCase()+"@gmail.com";
		this.tipo=tipo;
	}
	
	
	
	
	public void addDocumento(Documento<Bene> c) {
		documenti.add(c);
	}
	
	public void riceviBene(Bene b) {
		beniRicevuti.add(b);
	}
	
	public void stampaDocumenti() {
		for(Documento<Bene> doc : documenti) {
			doc.stampa();
			System.out.println("\n");
		}
	}
	
	public String stringaListaBeni() {
		
		String res="";
		
		for(Bene b : beniRicevuti) {
			res=res+b.stringa()+",";
		}
		
		return res;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public RagioneSociale getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(RagioneSociale ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}

