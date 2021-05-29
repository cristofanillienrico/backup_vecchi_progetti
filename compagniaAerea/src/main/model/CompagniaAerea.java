package main.model;

import java.util.ArrayList;
import java.util.Date;

import main.dao.DaoAereoImpl;
import main.dao.DaoAereoportoImpl;
import main.dao.DaoBigliettoImpl;
import main.dao.DaoPasseggeroImpl;
import main.dao.DaoPilotaImpl;
import main.dao.DaoVoloImpl;
import main.eccezioni.AereoVolaUnaVoltaAlGiornoException;
import main.eccezioni.AereoportoPartenzaArrivoException;
import main.eccezioni.BigliettoGiaPresenteException;
import main.eccezioni.VoloImpossibileException;

public class CompagniaAerea {
	
	private static CompagniaAerea compagniaAerea;
	
	private  DaoPilotaImpl implPilota;
	private DaoPasseggeroImpl implPasseggero;
	private DaoAereoImpl implAereo;
	private DaoVoloImpl implVolo;
	private DaoAereoportoImpl implAereoporto;
	private DaoBigliettoImpl implBiglietto;
	
	private CompagniaAerea() {
		this.implPilota= new DaoPilotaImpl();
		this.implPasseggero= new DaoPasseggeroImpl();
		this.implAereo=new DaoAereoImpl();
		this.implVolo=new DaoVoloImpl();
		this.implAereoporto= new DaoAereoportoImpl();
		this.implBiglietto= new DaoBigliettoImpl();
	}
	
	
	//singleton
	public static CompagniaAerea getInstance() {
		if(compagniaAerea==null) {
			compagniaAerea= new CompagniaAerea();
		}
		
		return compagniaAerea;
	}
	
	
	//metodi compagnia
	
	public void assumiPilota(String nome,String cognome) {
		Pilota pilota= new Pilota();
		pilota.setNome(nome);
		pilota.setCognome(cognome);
		pilota.setStipendio(5000);
		pilota.setIdStatoPilota(1);
		implPilota.insert(pilota);
	}
	
	
	public void acquistaAereo(String modello) {
		Aereo aereo= new Aereo();
		aereo.setModello(modello);
		aereo.setIdStatoAereo(1);
		implAereo.insert(aereo);
	}
	
	
	
	public boolean passeggeroIsInDatabase(Passeggero passegero){
		return implPasseggero.isInDatabase(passegero);
	}
	
	
	
	
//nel caso reale avrei il numero di passaparto,nazionalità ecc. per evitare omonimie	
	public void registraPasseggero(String nome,String cognome,String codiceFiscale,int idVolo) {
		
		
			
			
			//aggiunge passeggero se non registrato nel database
			Passeggero passeggero =implPasseggero.get(nome, cognome, codiceFiscale);
			
			if(passeggero==null) { //se non è registrato
				
				passeggero=new Passeggero();
				passeggero.setNome(nome);
				passeggero.setCognome(cognome);
				passeggero.setCodiceFiscale(codiceFiscale);
				implPasseggero.insert(passeggero);
				passeggero=implPasseggero.get(nome, cognome, codiceFiscale);
			
			}
			
			
			//calcolo prezzo biglietto
			Volo volo= implVolo.get(idVolo);
			int arrivo=volo.getOrarioArrivo().getHours();
			int partenza=volo.getOrarioPartenza().getHours();
			int prezzo =(arrivo-partenza)*10;
			
			
			//genero biglietto
			Biglietto biglietto= new Biglietto();
			biglietto.setPrezzo(prezzo);
			biglietto.setIdPasseggero(passeggero.getId());
			biglietto.setIdVolo(idVolo);
			implBiglietto.insert(biglietto);
			
			
		
	}
	

	public void organizzaVolo(int anno,int mese,int giorno,int oraPartenza,int oraArrivo,Aereo aereo,Pilota pilota,Aereoporto aereoportoPartenza,Aereoporto aereoportoArrivo ) {
		
		try {
			
			//sbarramenti generici per situazioni impossibili
			if(oraPartenza>oraArrivo || oraPartenza>22 || oraArrivo>24 || 
			   aereoportoPartenza==aereoportoArrivo || aereo.getIdStatoAereo()==2 ||
			   aereo.getIdStatoAereo()==3 || pilota.getIdStatoPilota()==2 ||
			   pilota.getIdStatoPilota()==3 ) {
				
				throw new VoloImpossibileException();
			}
			
			
			
			
			//aereoporto di partenza == aereoporto arrivo ultimo volo
			Aereoporto arrivoEffettivo=implAereo.aereoportoArrivoUltimoVolo(aereo);
			
			if(arrivoEffettivo!= null ) { //aereo ha gia volato una volta
				if(arrivoEffettivo.getId()!=aereoportoPartenza.getId()) {
					throw new AereoportoPartenzaArrivoException();
				}
			}
			
			
			
			
			
			//modifica stipendio del pilota in base al numero dei voli
			int numeroVoliPilota=implPilota.numeroVoli(pilota);
			if(numeroVoliPilota>5 && numeroVoliPilota<=10 ) {
				pilota.setStipendio(6000);
				implPilota.update(pilota);
			}else if(numeroVoliPilota>10 && numeroVoliPilota<=15){
				pilota.setStipendio(7000);
				implPilota.update(pilota);
			}else if(numeroVoliPilota>15 && numeroVoliPilota<=20){
				pilota.setStipendio(8000);
				implPilota.update(pilota);
			}else if(numeroVoliPilota>20 && numeroVoliPilota<=25){
				pilota.setStipendio(9000);
				implPilota.update(pilota);
			}else if(numeroVoliPilota>25 && numeroVoliPilota<=30){
				pilota.setStipendio(10000);
				implPilota.update(pilota);
			}
			
			
			
			Volo volo= new Volo();
			
			Date orarioPartenza= new Date(anno-1900,mese-1,giorno,oraPartenza,0);
			Date orarioArrivo= new Date(anno-1900,mese-1,giorno,oraArrivo,0);
			Date giornoVolo= new Date(anno-1900,mese-1,giorno);
			
			
			//aereo ha gia volato quel giorno?
			Date giornoIncriminato= implAereo.ultimoGiornoVolato(aereo);
			
			if(giornoIncriminato!= null ) { //aereo ha gia volato una volta
				if(giornoVolo.getYear()==giornoIncriminato.getYear() &&
						   giornoVolo.getMonth()==giornoIncriminato.getMonth() &&
						   giornoVolo.getDay()==giornoIncriminato.getDay())  {
							
							throw new AereoVolaUnaVoltaAlGiornoException();
						}
			}
			
			
			
			
			
			
			
			
			volo.setOrarioPartenza(orarioPartenza);
			volo.setOrarioArrivo(orarioArrivo);
			volo.setGiornoVolo(giornoVolo);
			volo.setAereoId(aereo.getId());
			volo.setPilotaId(pilota.getId());
			volo.setAereoportoPartenzaId(aereoportoPartenza.getId());
			volo.setAereoportoArrivoId(aereoportoArrivo.getId());
			implVolo.insert(volo);
			
		
		
		}catch(VoloImpossibileException e) {
			System.out.println("Volo illegale!!!");
			e.printStackTrace();
		}
		catch(AereoportoPartenzaArrivoException e) {
			System.out.println("Aereoporto di partenza diverso da quello di arrivo dell'ultimo volo effettuato");
			e.printStackTrace();
		}
		catch(AereoVolaUnaVoltaAlGiornoException e) {
			System.out.println("L'aereo ha già volato in questo giorno");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	public void aereoManutenzione(Aereo aereo,boolean bool)  {
		int stato=aereo.getIdStatoAereo();
		DaoAereoImpl impl= new DaoAereoImpl();
		try {
			if(stato==3) {
				throw new Exception();
			}
			
			if(bool==true) {
				aereo.setIdStatoAereo(2);
			}else {
				aereo.setIdStatoAereo(1);
			}
			
			impl.update(aereo);
			
		}catch(Exception e) {
			System.out.println("L'aereo è stato precedentemente dismesso");
		}
		
		
		
	}
	
	
	
	
	
	
	public void sospendiPilota(Pilota pilota,boolean bool)  {
		int stato=pilota.getIdStatoPilota();
		DaoPilotaImpl impl= new DaoPilotaImpl();
		try {
			if(stato==3) {
				throw new Exception();
			}
			
			if(bool==true) {
				pilota.setIdStatoPilota(2);
			}else {
				pilota.setIdStatoPilota(1);
			}
			
			impl.update(pilota);
			
		}catch(Exception e) {
			System.out.println("Il pilota è stato licenziato");
		}
		
		
		
	}
	
	
	
	
	public void modificaDatiVolo(Volo volo,Aereo aereo,Pilota pilota,Aereoporto aPartenza,Aereoporto aArrivo) {
		volo.setAereoId(aereo.getId());
		volo.setPilotaId(pilota.getId());
		volo.setAereoportoPartenzaId(aPartenza.getId());
		volo.setAereoportoArrivoId(aArrivo.getId());
		implVolo.update(volo);
		
	}
	
	
	
	public void dismettiAereo(Aereo aereo) {
		aereo.setIdStatoAereo(3);
		implAereo.update(aereo);
	}
	
	
	
	public void licenziaPilota(Pilota pilota) {
		pilota.setIdStatoPilota(3);
		implPilota.update(pilota);
	}
	
	
	public void annullaVolo(Volo volo) {
		
		//setta flag come annullato
		volo.setAnnullato(true);
		implVolo.update(volo);
		
		//cancella tutti i biglietti del volo
		implBiglietto.cancellaBigliettiVolo(volo);
		
	}
	
	
	public int numeroVoliPilota(Pilota pilota) {
		return implPilota.numeroVoli(pilota);
	}
	
	public Aereoporto aereoportoArrivoUltimoVolo(Aereo aereo) {
		return implAereo.aereoportoArrivoUltimoVolo(aereo);
	}
	
	public Date ultimoGiornoVolatoAereo(Aereo aereo) {
		return implAereo.ultimoGiornoVolato(aereo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodi crud
	public int numeroPilotiAttivi() {
		return implPilota.pilotiInAttivita();
	}
	
	
	public int passeggeriInVoloDa(String localita) {
		return implPasseggero.inVolo(localita);
	}
	
	public ArrayList<Aereo> aereiInVoloDataOra(Date data){
		return implAereo.aereiInVoloDataOra(data);
	}
	
	public Passeggero passeggeroVolatoPiuSpesso() {
		return implPasseggero.volatoPiuSpesso();
	}
	
	public Passeggero passeggeroSpesoDiPiu() {
		return implPasseggero.spesoDiPiu();
	}
	
	public Passeggero passeggeroMediaSpesoDiMeno() {
		return implPasseggero.mediaSpesoDiMeno();
	}
	
	public ArrayList<Passeggero> passeggeriVoloX(Volo volox){
		return implPasseggero.passeggeriVoloX(volox);
	}
	
	public Pilota pilotaVolatoDiPiu() {
		return implPilota.pilotaVolatoDiPiu();
	}
	
	public Pilota pilotaVolatoDiPiu(Date inizio,Date fine) {
		return implPilota.pilotaVolatoDiPiu(inizio, fine);
	}
	
	public Volo voloIncassatoDiPiu() {
		return implVolo.incassatoDiPiu();
	}
	
	public Volo voloIncassatoDiPiu(Date inizio,Date fine) {
		return implVolo.incassatoDiPiu(inizio, fine);
	}
	
	public ArrayList<Volo> voliInNegativo(Date giorno){
		return implVolo.voliInNegativo(giorno);
	}
	
	public ArrayList<Aereoporto> aereoportoAereoXGiorni(Aereo aereo,int xGiorni){
		return implAereoporto.aereoportiAereoXgiorni(aereo, xGiorni);
	}
	
	public Aereoporto aereoportoPiuAereiGiornoX(Date giorno) {
		return implAereoporto.piuAereiGiornoX(giorno);
	}
	
	public int numPasseggeriGiornoAereoporto(Date giorno, Aereoporto aereoporto) {
		return implPasseggero.numPasseggeriGiornoAereoporto(giorno, aereoporto);
	}
	
	public int guadagno() {
		return implPilota.guadagnoCompagnia();
	}
	
	public int guadagno(Date inizio,Date fine) {
		return implPilota.guadagnoCompagnia(inizio, fine);
	}

}
