package main.dao;

import java.util.ArrayList;
import java.util.Date;

import main.model.Volo;

public interface DaoVolo extends Dao<Volo,Integer>{
	
//	/* qual è il volo che ha incassato di più? 
//	(da prevedere che venga specificato un intervallo di
//	 tempo o non venga specificato nulla, a quel punto deve segnalare quello che ha incassato di più
//	  in assoluto)*
	public abstract Volo incassatoDiPiu();
	public abstract Volo incassatoDiPiu(Date inizio,Date fine);
	
	
//	quali sono i voli per cui la compagnia ci ha rimesso in un dato giorno? (guadagno negativo)
	public abstract ArrayList<Volo> voliInNegativo(Date giorno);
	
	  
	
}
