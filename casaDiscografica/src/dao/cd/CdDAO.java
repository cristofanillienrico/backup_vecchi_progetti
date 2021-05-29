package dao.cd;

import java.util.List;

import dao.IBaseDAO;
import model.Autore;
import model.Cd;

public interface CdDAO extends IBaseDAO<Cd> {
	
	public List<Cd> findAllByGenere(String genere) throws Exception;
	
	public List<Cd> findAllByAutoreWhereTitolStartsWith(Autore autoreInput,String iniziale)throws Exception;

}
