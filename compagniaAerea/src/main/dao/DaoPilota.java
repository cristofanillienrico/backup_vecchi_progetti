package main.dao;

import java.util.Date;

import main.model.Pilota;

public interface DaoPilota extends Dao <Pilota,Integer>{
	
	//	quanti sono i piloti in attività?
	public abstract int pilotiInAttivita();

//	 quale pilota ha volato di più? 
//	(da prevedere che venga specificato un intervallo di tempo o non venga specificato nulla,
//	a quel punto deve segnalare quello che ha volato di più in assoluto)
	public abstract Pilota pilotaVolatoDiPiu();
	public abstract Pilota pilotaVolatoDiPiu(Date inizio, Date fine);
	
	
	//numero voli pilota
	public abstract int numeroVoli(Pilota pilota);
	
	

	
	//	quanto ha guadagnato la compagnia? 
//	(da prevedere che venga specificato un intervallo di tempo o non venga specificato nulla,
//	a quel punto deve segnalare quanto ha guadagnato in senso assoluto)
	public abstract  int guadagnoCompagnia();
	public abstract int guadagnoCompagnia(Date inizio, Date fine);
	

}
