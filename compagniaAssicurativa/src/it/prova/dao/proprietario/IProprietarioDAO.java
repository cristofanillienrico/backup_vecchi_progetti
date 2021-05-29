package it.prova.dao.proprietario;

import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.Proprietario;

public interface IProprietarioDAO extends IBaseDAO<Proprietario> {

	public void populateAutomobili(Proprietario proprietario) throws Exception;

	public List<Proprietario> ownersCarsWithInsuranceCompanyInMilan() throws Exception;

	public List<Proprietario> ownersCarsInsuredWithCompanyThatHasLessTwentyCars() throws Exception;

}
