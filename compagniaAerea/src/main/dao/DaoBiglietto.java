package main.dao;

import main.model.Biglietto;
import main.model.Volo;

public interface DaoBiglietto extends Dao<Biglietto,Integer>{
	//cancella biglietti di un volo
	public abstract void cancellaBigliettiVolo(Volo volo);
	

}
