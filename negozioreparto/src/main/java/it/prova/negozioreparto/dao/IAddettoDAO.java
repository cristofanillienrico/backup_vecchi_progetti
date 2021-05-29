package it.prova.negozioreparto.dao;

import java.util.List;

import it.prova.negozioreparto.model.Addetto;
import it.prova.negozioreparto.model.Reparto;

public interface IAddettoDAO extends IBaseDAO<Addetto> {

	public List<Reparto> tuttiRepartiDaAddetto(Addetto addettoInstance) throws Exception;

}
