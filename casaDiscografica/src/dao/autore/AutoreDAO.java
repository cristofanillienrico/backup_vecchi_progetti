package dao.autore;

import java.util.List;

import dao.IBaseDAO;
import model.Autore;
import model.CasaDiscografica;

public interface AutoreDAO extends IBaseDAO<Autore>{
	
	public void populateCd(Autore autore) throws Exception;
	
	public List<Autore> findAllByCasaDiscografica(CasaDiscografica input) throws Exception;
	
	public List<Autore> findByCdWhereNTracceGraterThen(int nTracce) throws Exception;

}
