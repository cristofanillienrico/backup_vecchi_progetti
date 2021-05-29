package it.prova.gestionegalleria.dao;

import java.util.List;

import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Restauratore;

public interface IRestauratoreDAO extends IBaseDAO<Restauratore> {

	public List<Quadro> tuttiQuadriDaRestauratore(Restauratore restauratoreInstance) throws Exception;

}
