package it.prova.manytomanycdmaven.dao.cd;

import java.util.List;

import it.prova.manytomanycdmaven.dao.IBaseDAO;
import it.prova.manytomanycdmaven.model.Cd;
import it.prova.manytomanycdmaven.model.Genere;

public interface CdDAO extends IBaseDAO<Cd> {

	// METODI

	public List<Cd> findAllByGenere(Genere genere) throws Exception;

	public Cd whereTitoloIs(String titolo) throws Exception;

}
