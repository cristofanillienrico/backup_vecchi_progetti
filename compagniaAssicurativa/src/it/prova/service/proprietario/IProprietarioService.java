package it.prova.service.proprietario;

import java.util.List;

import it.prova.dao.automobile.IAutomobileDAO;
import it.prova.dao.proprietario.IProprietarioDAO;
import it.prova.model.Proprietario;

public interface IProprietarioService {

	// questo mi serve per injection
	public void setProprietarioDao(IProprietarioDAO proprietarioDao);

	public void setAutomobileDao(IAutomobileDAO automobileDAO);

	public List<Proprietario> listAll() throws Exception;

	public Proprietario findById(Long idInput) throws Exception;

	public int aggiorna(Proprietario input) throws Exception;

	public int inserisciNuovo(Proprietario input) throws Exception;

	public int rimuovi(Proprietario input) throws Exception;

	public List<Proprietario> findByExample(Proprietario input) throws Exception;

	public List<Proprietario> proprietariDiAutomobiliConCompagniaAssicurativaAMilano() throws Exception;

	public List<Proprietario> proprietarioMacchineAssicurateConComapagnieMenoDiVentiAutomobili() throws Exception;
}
