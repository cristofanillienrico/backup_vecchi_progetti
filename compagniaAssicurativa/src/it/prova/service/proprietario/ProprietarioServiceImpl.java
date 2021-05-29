package it.prova.service.proprietario;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.automobile.IAutomobileDAO;
import it.prova.dao.proprietario.IProprietarioDAO;
import it.prova.model.Automobile;
import it.prova.model.Proprietario;

public class ProprietarioServiceImpl implements IProprietarioService {
	
	private IProprietarioDAO proprietarioDao;
	private IAutomobileDAO automobileDao;

	@Override
	public void setProprietarioDao(IProprietarioDAO proprietarioDao) {
		this.proprietarioDao=proprietarioDao;
		
	}
	
	@Override
	public void setAutomobileDao(IAutomobileDAO automobileDAO) {
		this.automobileDao=automobileDAO;
		
	}

	@Override
	public List<Proprietario> listAll() throws Exception {
		List<Proprietario> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Proprietario findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");
		
		Proprietario result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiorna(Proprietario input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciNuovo(Proprietario input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");
		
		
		
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuovi(Proprietario input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);
			automobileDao.setConnection(connection);
			
			proprietarioDao.populateAutomobili(input);
			if(input.getListaAutomobili().size() > 0 ) {
				for(Automobile automobileItem : input.getListaAutomobili()) {
					automobileDao.delete(automobileItem);
				}
			}

			// eseguo quello che realmente devo fare
			result = proprietarioDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Proprietario> findByExample(Proprietario input) throws Exception {
		List<Proprietario> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Proprietario> proprietariDiAutomobiliConCompagniaAssicurativaAMilano() throws Exception {
		List<Proprietario> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.ownersCarsWithInsuranceCompanyInMilan();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Proprietario> proprietarioMacchineAssicurateConComapagnieMenoDiVentiAutomobili() throws Exception {
		List<Proprietario> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			proprietarioDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = proprietarioDao.ownersCarsInsuredWithCompanyThatHasLessTwentyCars();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	

}
