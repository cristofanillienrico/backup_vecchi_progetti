package it.prova.negozioreparto.dao;

import java.util.List;

import it.prova.negozioreparto.model.Negozio;
import it.prova.negozioreparto.model.Reparto;

public interface INegozioDAO extends IBaseDAO<Negozio> {

	public List<Reparto> allRepartiByNegozio(Negozio negozioInstance) throws Exception;

	public List<Negozio> listNegoziWithAddettoWithCognome(String cognome) throws Exception;

}
