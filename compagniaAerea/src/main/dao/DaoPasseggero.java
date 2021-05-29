package main.dao;

import java.util.ArrayList;
import java.util.Date;

import main.model.Aereoporto;
import main.model.Passeggero;
import main.model.Volo;

public interface DaoPasseggero extends Dao<Passeggero, Integer> {
	
//	quanti passeggeri sono in volo da una certa località?
	public abstract int inVolo(String località);
	
//	 qual è il passeggero che ha volato più spesso con la compagnia?
	public abstract Passeggero volatoPiuSpesso();
	
//	qual è il passeggero che ha speso di più volando con la compagnia?
	public abstract Passeggero spesoDiPiu();
	
//	qual è il passeggero che in media ha speso di meno volando con la compagnia?
	public abstract Passeggero mediaSpesoDiMeno();
	
//	chi sono i passeggerei del volo x? (nome, cognome, codice fiscale...)
	public abstract ArrayList<Passeggero> passeggeriVoloX(Volo voloX);
	
//	quanti passeggeri sono previsti in arrivo un dato giorno al dato aeroporto?
	public abstract int numPasseggeriGiornoAereoporto(Date giorno,Aereoporto aereoporto);
	
//	passeggero presente in database
	public abstract boolean isInDatabase(Passeggero passeggero);
	
//	get passeggero dato nome,cognome,codice_fiscale
	public abstract Passeggero get(String nome,String cognome, String codiceFiscale);
}
