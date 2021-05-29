package main.model;

import main.dao.DipendentiDao;
import main.dao.DipendentiDaoImpl;

public class Main {

	public static void main(String[] args) {
		
		//prendo un dipendente da chiave id
		DipendentiDao dipendenteDao = new DipendentiDaoImpl();
		Dipendenti dipendente = dipendenteDao.get(1);
		if(dipendente!=null) {
			System.out.println(dipendente.toString());
		}else {
			System.out.println("Nessun risultato");
		}
		
		
		//prende una lista di tutti i dipendenti
		System.out.println(dipendenteDao.getAll().toString());
		
		
		//creo nuovo dipendente e lo inserisco nel database
		Dipendenti nuovo=new Dipendenti("Ultimo","Ultimi"); 
		dipendenteDao.insert(nuovo);
		
		//elimino dipendente da chiave id
		dipendenteDao.delete(2);
		
		
		//modifico dipendente
		Dipendenti umberto=dipendenteDao.get(5);
		dipendenteDao.update(umberto, "modificato", "da Java");

	}

}
