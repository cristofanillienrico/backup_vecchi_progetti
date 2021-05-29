package pacchetto;

public class Documento <T extends Bene> {
	
	private String telefono="";
	private RagioneSociale ragioneSociale;
	private String indirizzo="";
	private String nome="";
	private String nomeBene="";
	private double valore=0.0;
	private String mail="";
	
	
	
	
	
	public Documento(Beneficiario des,T bene) {
		this.telefono=des.getTelefono();
		this.ragioneSociale=des.getRagioneSociale();
		this.indirizzo=des.getIndirizzo();
		this.nome=des.getNome();
		this.nomeBene=bene.getClass().getSimpleName();//dal nome della classe a stringa
		this.valore=bene.getValore();
		this.mail=des.getMail();
		
		
		
	}
	
	public void stampa() {
		System.out.println("Con la presente si attesta che la società "+nome+" "+ragioneSociale.toString().toLowerCase()+
				" situata in "+indirizzo+ " riceverà un "+nomeBene+" dal valore nominale di "+
				valore+  " $ \n"+"L'Agenzia si riserverà di contattare la suddetta società al numero "+telefono+
				" oppure alla casella postale "+mail);
	}

}
