package it.prova.dao.compagniaassicurativa;

import it.prova.dao.IBaseDAO;
import it.prova.model.CompagniaAssicurativa;

public interface ICompagniaAssicurativaDAO extends IBaseDAO<CompagniaAssicurativa> {

	public void populateAutomobili(CompagniaAssicurativa compagniaAssicurativa) throws Exception;

}
