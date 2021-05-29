package pacchetto;

import java.util.ArrayList;

import pacchetto.Beneficiario.Tipo;

public class Test {

	public static void main(String[] args) {
		
		Beneficiario museiVaticani= new Beneficiario("MuseiVaticani",Tipo.MUSEI,RagioneSociale.SNC,"064534567","stato vaticano");
		Beneficiario eni= new Beneficiario("Eni",Tipo.ENTI,RagioneSociale.SPA,"065674294"," via cagliari");
		Beneficiario unicef= new Beneficiario("Unicef",Tipo.NOPROFIT,RagioneSociale.SRL,"067823150","via brindisi");
		Beneficiario sapienza =new Beneficiario("Sapienza",Tipo.RICERCA,RagioneSociale.SRLS,"061234567","viale dell'iniversità");
		
		Rubrica rubrica=new Rubrica();
		rubrica.addBeneficiario(sapienza);
		rubrica.addBeneficiario(eni);
		rubrica.addBeneficiario(unicef);
		rubrica.addBeneficiario(museiVaticani);
		
		Agenzia agenzia=new Agenzia(rubrica);
		
		
		Moto suzuki=new Moto("064534567",1000);
		Automobile fiat= new Automobile("065674294",1200);
		Appartamento app= new Appartamento("067823150",60);
		Villa vill= new Villa("061234567",100);
		OperaArte quadro= new OperaArte("064534567","Golconda","Magritte",1953);
		Gioiello smeraldo= new Gioiello("064534567",2354);
		
		ArrayList <Bene> listaBeni= new ArrayList<>();
		listaBeni.add(vill);
		listaBeni.add(suzuki);
		listaBeni.add(fiat);
		listaBeni.add(app);
		listaBeni.add(quadro);
		listaBeni.add(smeraldo);
		
		agenzia.riceviListaBeni(listaBeni);
		agenzia.consegnaDocumenti();
		

		sapienza.stampaDocumenti();
		
		agenzia.termineAssegnazione();
		
		
		

	}

}
