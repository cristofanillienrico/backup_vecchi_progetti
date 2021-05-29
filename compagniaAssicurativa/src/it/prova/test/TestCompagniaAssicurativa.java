package it.prova.test;

import java.util.Calendar;
import java.util.Date;

import it.prova.dao.proprietario.IProprietarioDAO;
import it.prova.model.Automobile;
import it.prova.model.CompagniaAssicurativa;
import it.prova.model.Proprietario;
import it.prova.service.MyServiceFactory;
import it.prova.service.automobile.IAutomobileService;
import it.prova.service.compagniaassicurativa.ICompagniaAssicurativaService;
import it.prova.service.proprietario.IProprietarioService;

public class TestCompagniaAssicurativa {

	public static void main(String[] args) {

		try {

			ICompagniaAssicurativaService compagniaAssicurativaService = MyServiceFactory
					.getICompagniaAssicurativaService();
			IProprietarioService proprietarioService = MyServiceFactory.getIProprietarioService();
			IAutomobileService automobileService = MyServiceFactory.getIAutomobileService();

			// valori di prova accessori per i test
			Calendar calendario = Calendar.getInstance();
			calendario.set(2021, 3, 11);
			Date dataDiProva = calendario.getTime();
//			System.out.println(dataDiProva);

//			System.out.println(compagniaAssicurativaService.findById(1L));
//			
//			System.out.println(compagniaAssicurativaService.listAll());

//			CompagniaAssicurativa miaCompagnia=new CompagniaAssicurativa("prova",dataDiProva,"via di prova,Prova");
//			compagniaAssicurativaService.inserisciNuovo(miaCompagnia);

//			CompagniaAssicurativa compagniaModificabile=compagniaAssicurativaService.findById(3L);
//			compagniaModificabile.setRagioneSociale("modificato");
//			compagniaAssicurativaService.aggiorna(compagniaModificabile);

//			CompagniaAssicurativa compagniaEliminabile=compagniaAssicurativaService.findById(1L);
//			compagniaAssicurativaService.rimuovi(compagniaEliminabile);

//			System.out.println(proprietarioService.findById(1L));
//			
//			System.out.println(proprietarioService.listAll());

//			Proprietario proprietarioDiProva= new Proprietario("Emanuele","Trisi",dataDiProva);
//			proprietarioService.inserisciNuovo(proprietarioDiProva);

//			Proprietario proprietarioModificabile=proprietarioService.findById(3L);
//			proprietarioModificabile.setNome("modificato");
//			proprietarioService.aggiorna(proprietarioModificabile);

//			Proprietario proprietarioEliminabile=proprietarioService.findById(3L);
//			proprietarioService.rimuovi(proprietarioEliminabile);

//			System.out.println(automobileService.findById(1L));
//			
//			System.out.println(automobileService.listAll());

//			qui deve andare in eccezione 
//			Proprietario proprietarioDiProva = new Proprietario("Emanuele", "Trisi", dataDiProva);
//			CompagniaAssicurativa miaCompagnia = new CompagniaAssicurativa("prova", dataDiProva, "via di prova,Prova");
//			Automobile automobileDiProva = new Automobile("Ford", "Mustang", 34234, dataDiProva, miaCompagnia,
//					proprietarioDiProva);
//			automobileService.inserisciNuovo(automobileDiProva);

//			CompagniaAssicurativa miaCompagnia=compagniaAssicurativaService.findById(1L);
//			Proprietario mioProprietario=proprietarioService.findById(1L);
//			Automobile automobileDiProva=new Automobile("Ford", "Mustang", 34234, dataDiProva, miaCompagnia, mioProprietario);
//			automobileService.inserisciNuovo(automobileDiProva);
//			

//			Automobile miaAutomobile=automobileService.findById(1L);
//			miaAutomobile.setMarca("modificato");
//			automobileService.aggiorna(miaAutomobile);

//			Automobile miaAutomobile=automobileService.findById(5L);
//			System.out.println(miaAutomobile);
//			automobileService.rimuovi(miaAutomobile);

			// find by example

//			Proprietario mioProprietario=proprietarioService.findById(1L);
//			System.out.println(proprietarioService.findByExample(mioProprietario));

//			Automobile miaAutomobile=automobileService.findById(10L);
//			System.out.println(automobileService.findByExample(miaAutomobile));

//			CompagniaAssicurativa miaCompagnia=compagniaAssicurativaService.findById(1L);
//			System.out.println(compagniaAssicurativaService.findByExample(miaCompagnia));

			// metodi richiesti per l'applicazione

//			System.out.println(automobileService.automobiliConProprietarioCheHaPiuDiQuarantaAnni());

//			System.out.println(proprietarioService.proprietariDiAutomobiliConCompagniaAssicurativaAMilano());

//			System.out.println(proprietarioService.proprietarioMacchineAssicurateConComapagnieMenoDiVentiAutomobili());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
