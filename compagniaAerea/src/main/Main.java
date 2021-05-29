package main;

import main.dao.DaoVoloImpl;
import main.model.CompagniaAerea;
import main.model.Volo;

public class Main {

	public static void main(String[] args) {
		
		CompagniaAerea compagnia = CompagniaAerea.getInstance();
		
		//metodi compagnia
		
//		compagnia.assumiPilota("Panfilo", "Panfili");
		
//		compagnia.acquistaAereo("Airbus 380");
		
//		DaoPasseggeroImpl impl= new DaoPasseggeroImpl();
//		Passeggero p1 = impl.get(12);
//		Passeggero p2= new Passeggero();
//		System.out.println(compagnia.passeggeroIsInDatabase(p1));
//		System.out.println(compagnia.passeggeroIsInDatabase(p2));
		
		
		
//		compagnia.registraPasseggero("Gianni", "Bolo", "sbiwuedb38",6);
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		DaoPilotaImpl implPilota= new DaoPilotaImpl();
//		DaoAereoportoImpl implAereoporto= new DaoAereoportoImpl();
//		Aereo aereo=implAereo.get(3);
//		Pilota pilota=implPilota.get(2);
//		Aereoporto aPratenza=implAereoporto.get(3);
////		System.out.println(aPratenza);
//		Aereoporto aArrivo=implAereoporto.get(5);
////		System.out.println(compagnia.aereoportoArrivoUltimoVolo(aereo));
//		compagnia.organizzaVolo(2021, 3, 1, 8, 14, aereo, pilota, aPratenza, aArrivo);
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		Aereo aereo=implAereo.get(6);
//		compagnia.aereoManutenzione(aereo,true);
		
		
//		DaoPilotaImpl implPilota = new DaoPilotaImpl();
//		Pilota pilota=implPilota.get(6);
//		compagnia.sospendiPilota(pilota,true);
		
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		DaoPilotaImpl implPilota= new DaoPilotaImpl();
//		DaoAereoportoImpl implAereoporto= new DaoAereoportoImpl();
//		DaoVoloImpl implVolo= new DaoVoloImpl();
//		Aereo aereo=implAereo.get(3);
//		Pilota pilota=implPilota.get(2);
//		Aereoporto aPratenza=implAereoporto.get(1);
//		Aereoporto aArrivo=implAereoporto.get(2);
//		Volo volo=implVolo.get(10);
//		compagnia.modificaDatiVolo(volo, aereo, pilota, aPratenza, aArrivo);
		
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		Aereo aereo=implAereo.get(13);
//		compagnia.dismettiAereo(aereo);
		
		
		
//		DaoPilotaImpl implPilota= new DaoPilotaImpl();
//		Pilota pilota=implPilota.get(16);
//		compagnia.licenziaPilota(pilota);
		
		
		
//		DaoVoloImpl implVolo= new DaoVoloImpl();
//		Volo volo=implVolo.get(6);
//		compagnia.annullaVolo(volo);
//		
//		
		
//		DaoPilotaImpl impl= new DaoPilotaImpl();
//		Pilota pilota=impl.get(13);
//		System.out.println(compagnia.numeroVoliPilota(pilota));
		
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		Aereo aereo=implAereo.get(8);
//		System.out.println(compagnia.aereoportoArrivoUltimoVolo(aereo));
		
		
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		Aereo aereo=implAereo.get(8);
//		System.out.println(compagnia.ultimoGiornoVolatoAereo(aereo));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//metodi crud
//		System.out.println(compagnia.numeroPilotiAttivi());
//		
//		System.out.println(compagnia.passeggeriInVoloDa("Roma"));
//		
//		
//		Date data= new Date(2021-1900,2,31,11,0);
//		System.out.println(data);
//		System.out.println(compagnia.aereiInVoloDataOra(data));
//		
//		
//		System.out.println(compagnia.passeggeroVolatoPiuSpesso());
//		
//		
//		System.out.println(compagnia.passeggeroSpesoDiPiu());
//		
//		
//		System.out.println(compagnia.passeggeroMediaSpesoDiMeno());
		
		
//		DaoVoloImpl implVolo = new DaoVoloImpl();
//		Volo volo= implVolo.get(1);
//		System.out.println(compagnia.passeggeriVoloX(volo));
		
//		System.out.println(compagnia.pilotaVolatoDiPiu());
		
//		DaoVoloImpl implVolo = new DaoVoloImpl();
//		Volo v=implVolo.get(1);
//		System.out.println(v);
//		Timestamp inizio= new Timestamp(v.getOrarioPartenza().getTime());
//		Timestamp fine= new Timestamp(v.getOrarioArrivo().getTime());
//		System.out.println(compagnia.pilotaVolatoDiPiu(inizio, fine));
		
//		System.out.println(compagnia.voloIncassatoDiPiu());
		
//		DaoVoloImpl implVolo = new DaoVoloImpl();
//		Volo v=implVolo.get(1);
//		Timestamp inizio= new Timestamp(v.getOrarioPartenza().getTime());
//		Timestamp fine= new Timestamp(v.getOrarioArrivo().getTime());
//		System.out.println(compagnia.voloIncassatoDiPiu(inizio,fine));

		
//		DaoVoloImpl implVolo = new DaoVoloImpl();
//		Volo v=implVolo.get(7);
//		System.out.println(compagnia.voliInNegativo(v.getGiornoVolo()));
		
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		Aereo a=implAereo.get(6);
//		System.out.println(compagnia.aereoportoAereoXGiorni(a, 10));
		
		
//		Date data= new Date(2021-1900,2,31);
//		System.out.println(compagnia.aereoportoPiuAereiGiornoX(data));
		
		
//		Date data = new Date(2025-1900,0,31);
//		DaoAereoportoImpl impl = new DaoAereoportoImpl();
//		Aereoporto a=impl.get(4);
//		System.out.println(compagnia.numPasseggeriGiornoAereoporto(data, a));
		
		
//		System.out.println(compagnia.guadagno());
		

//		Date inizio= new Date(2021-1900,2,31,9,0);
//		Date fine= new Date(2021-1900,2,31,10,0);
//		System.out.println(compagnia.guadagno(inizio, fine));
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Prove
//		Date data = new Date();
//		System.out.println(data);
//		
//		int xGiorni=10;
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(data);
//		cal.add(Calendar.DATE, -xGiorni);
//		Date dateBeforeXDays = cal.getTime();
//		System.out.println(dateBeforeXDays);
//	
	
		
//		Date data = new Date();
//		System.out.println(data.get);
		
		
		
//		DaoBigliettoImpl impl = new DaoBigliettoImpl();
//		System.out.println(impl.get(2));
//		System.out.println(impl.getAll());
//		Biglietto b= new Biglietto();
//		b.setPrezzo(1);
//		b.setIdPasseggero(1);
//		b.setIdVolo(1);
//		impl.insert(b);
		
//		b=impl.get(8);
//		System.out.println(b);
//		b.setPrezzo(3333);
//		impl.update(b);
		
//		impl.delete(8);
		
//		DaoAereoImpl implAereo = new DaoAereoImpl();
//		DaoPilotaImpl implPilota= new DaoPilotaImpl();
//		DaoAereoportoImpl implAereoporto= new DaoAereoportoImpl();
//		Aereo aereo=implAereo.get(14);
//		Pilota pilota=implPilota.get(2);
//		Aereoporto aPratenza=implAereoporto.get(3);
////		System.out.println(aPratenza);
//		Aereoporto aArrivo=implAereoporto.get(5);
////		System.out.println(compagnia.aereoportoArrivoUltimoVolo(aereo));
//		compagnia.organizzaVolo(2021, 3, 1, 8, 14, aereo, pilota, aPratenza, aArrivo);

	}

}
