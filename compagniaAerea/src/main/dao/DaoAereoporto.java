package main.dao;

import java.util.ArrayList;
import java.util.Date;

import main.model.Aereo;
import main.model.Aereoporto;

public interface DaoAereoporto extends Dao<Aereoporto, Integer> {
	
//	quali sono gli aeroporti dove un certo aereo è atterrato negli ultimi x giorni?
	public abstract ArrayList<Aereoporto> aereoportiAereoXgiorni(Aereo aereo,int giorni);
	
//	da qual aeroporto sono partiti più aerei il giorno x?
	public abstract Aereoporto piuAereiGiornoX(Date giorno);
}
