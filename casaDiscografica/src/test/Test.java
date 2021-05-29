package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Autore;
import model.CasaDiscografica;
import model.Cd;
import service.MyServiceFactory;
import service.autore.AutoreService;
import service.casadiscografica.CasaDiscograficaService;
import service.cd.CdService;

public class Test {
	
	public static void main(String [] args) {
		
		CasaDiscograficaService casaDiscograficaService=MyServiceFactory.getCasaDiscograficaServiceImpl();
		AutoreService autoreService= MyServiceFactory.getAutoreServiceImpl();
		CdService cdService=MyServiceFactory.getCdServiceImpl();
		
		try {
//			System.out.println(casaDiscograficaService.listAll());
			
//			System.out.println(casaDiscograficaService.findById((long)1));
			
//			String data2="2021-04-07";
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//			Date data=format.parse(data2);
//			CasaDiscografica miaCasa= new CasaDiscografica("mia","via idsd",data);
//			System.out.println(casaDiscograficaService.inserisciNuovo(miaCasa));
			
//			CasaDiscografica incriminata=casaDiscograficaService.findById((long)1);
//			incriminata.setIndirizzo("modificato");
//			casaDiscograficaService.aggiorna(incriminata);
			
			
			
			
			
			
			
//			System.out.println(autoreService.listAll());
			
//			System.out.println(autoreService.findById((long)1));
			
			
//			String data2="2021-04-07";
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//			Date data=format.parse(data2);
//			CasaDiscografica miaCasa= casaDiscograficaService.findById((long)2);
//			Autore mioAutore=new Autore("sds","dffs",data,"fdfd",miaCasa);
//			autoreService.inserisciNuovo(mioAutore);
			
			
//			Autore mioAutore=autoreService.findById((long)1);
//			mioAutore.setNickname("modificato");
//			autoreService.aggiorna(mioAutore);
			
			
			
			
			
			
			
			
//			System.out.println(cdService.listAll());
			
//			System.out.println(cdService.findById((long)1));
			
			
			
//			Autore mioAutore=autoreService.findById((long)2);
//			Cd nuovo= new Cd("titolo","genere",21,mioAutore);
//			cdService.inserisciNuovo(nuovo);
			
			
//			Cd mio=cdService.findById((long)1);
//			mio.setNumeroTracce(5000);
//			cdService.aggiorna(mio);
			
			
			
			
			
//			CasaDiscografica miaCasa= casaDiscograficaService.findById((long)2);
//			System.out.println(miaCasa);
//			System.out.println(miaCasa.getListaAutori());
//			casaDiscograficaService.popolaAutori(miaCasa);
//			System.out.println(miaCasa);
			
			
			
//			CasaDiscografica miaCasa= casaDiscograficaService.findById((long)4);
//			casaDiscograficaService.rimuovi(miaCasa);
			
			
			
//			Cd mio=cdService.findById((long)6);
//			cdService.rimuovi(mio);
			
			
			
			
//			Autore mioAutore=autoreService.findById((long)2);
//			System.out.println(mioAutore);
//			autoreService.popolaCd(mioAutore);
//			System.out.println(mioAutore);
			
			
			
			
//			Autore mioAutore=autoreService.findById(2L);
//			autoreService.rimuovi(mioAutore);
			
			
//			Autore mioAutore=autoreService.findById(3L);
//			System.out.println(casaDiscograficaService.casaDiscograficaTrovaDaAutore(mioAutore));
			
			
			
			
			
//			System.out.println(casaDiscograficaService.trovaTuttiDaAutoreDoveCognomeIniziaCon("c"));
			
			
			
//			System.out.println(casaDiscograficaService.trovaTuttiDaCdDoveGenereUgualeA("classica"));
			
			
//			CasaDiscografica miaCasa= casaDiscograficaService.findById(1L);
//			System.out.println(autoreService.trovaTuttiPerCasaDiscografica(miaCasa));
			
			
//			System.out.println(autoreService.trovaConCdDoveTracceMaggioriDi(10));
			
			
//			System.out.println(cdService.trovaTuttiDaGenere("rock"));
			
//			Autore mioAutore=autoreService.findById(3L);
//			System.out.println(cdService.trovaTuttiDaAutoreDoveTitoloIniziaCon(mioAutore, "g"));
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			CasaDiscografica miaCasa= casaDiscograficaService.findById(1L);
//			System.out.println(casaDiscograficaService.findByExample(miaCasa));
			
			
			
//			Autore mioAutore=autoreService.findById(3L);
//			System.out.println(autoreService.findByExample(mioAutore));
			
			
			
			
			Cd mio=cdService.findById((long)2);
			System.out.println(cdService.findByExample(mio));
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
