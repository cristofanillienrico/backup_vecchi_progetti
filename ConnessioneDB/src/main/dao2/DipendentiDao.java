package main.dao2;

import java.util.ArrayList;

import main.model.Dipendenti;

public abstract class DipendentiDao extends Dao {
	
	public abstract Dipendenti get(int id);
	public abstract ArrayList<Dipendenti> getAll();
	public abstract void insert(Dipendenti dipendente);
	public abstract void update(Dipendenti dipendente,String nome,String cognome);
	public abstract void delete(int id);
//	
	



}
