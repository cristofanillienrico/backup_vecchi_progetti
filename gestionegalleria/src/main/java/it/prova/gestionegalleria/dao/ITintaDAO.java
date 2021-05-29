package it.prova.gestionegalleria.dao;

import java.util.List;

import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public interface ITintaDAO extends IBaseDAO<Tinta> {

	public List<Quadro> tuttiQuadriDaTinta(Tinta tintaInstance) throws Exception;

}
