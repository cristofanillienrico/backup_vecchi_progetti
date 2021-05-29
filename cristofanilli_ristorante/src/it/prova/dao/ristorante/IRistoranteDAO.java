package it.prova.dao.ristorante;

import it.prova.dao.IBaseDAO;
import it.prova.model.Ristorante;

public interface IRistoranteDAO extends IBaseDAO<Ristorante>{
	
	public Ristorante getEagerClienti(Long id) throws Exception;

}
