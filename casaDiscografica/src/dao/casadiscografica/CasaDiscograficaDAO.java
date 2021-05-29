package dao.casadiscografica;

import java.util.List;

import dao.IBaseDAO;
import model.Autore;
import model.CasaDiscografica;

public interface CasaDiscograficaDAO extends IBaseDAO<CasaDiscografica>{
	
	public void populateAuthors(CasaDiscografica input) throws Exception;
	
	public CasaDiscografica casaDiscograficaFindByAutore(Autore input) throws Exception;
	
	public List<CasaDiscografica> findAllByAutoreWhereSurnameStartsWith(String iniziale) throws Exception;
	
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere) throws Exception;

}
