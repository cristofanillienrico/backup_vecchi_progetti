package main.dao;

import java.util.ArrayList;
import java.util.Date;

import main.model.Aereo;
import main.model.Aereoporto;

public interface DaoAereo extends Dao<Aereo, Integer> {

//	quali aerei sono in volo in una certa data e ora?
	public abstract ArrayList<Aereo> aereiInVoloDataOra(Date data);
	
	
	//aereoporto arrivo ultimo volo
	public Aereoporto aereoportoArrivoUltimoVolo(Aereo aereo);
	
	//ultimo giorno in cui aereo ha volato
	public Date ultimoGiornoVolato(Aereo aereo);

}