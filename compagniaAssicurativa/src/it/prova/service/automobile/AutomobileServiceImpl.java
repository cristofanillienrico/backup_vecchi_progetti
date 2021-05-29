package it.prova.service.automobile;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.automobile.IAutomobileDAO;
import it.prova.dao.compagniaassicurativa.ICompagniaAssicurativaDAO;
import it.prova.dao.proprietario.IProprietarioDAO;
import it.prova.model.Automobile;

public class AutomobileServiceImpl implements IAutomobileService {
	
	private IAutomobileDAO automobileDao;
	private ICompagniaAssicurativaDAO compagniaAssicurativaDao;
	private IProprietarioDAO proprieatarioDao;

	@Override
	public void setAutomobileDao(IAutomobileDAO automobileDao) {
		this.automobileDao=automobileDao;
		
	}
	@Override
	public void setProprietarioDao(IProprietarioDAO proprietarioDao) {
		this.proprieatarioDao=proprietarioDao;
		
	}

	@Override
	public void setCompagniaAssicurativaDao(ICompagniaAssicurativaDAO compagniaAssicurativaDAO) {
		this.compagniaAssicurativaDao=compagniaAssicurativaDAO;
		
	}

	@Override
	public List<Automobile> listAll() throws Exception {
		List<Automobile> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = automobileDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Automobile findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");
		
		Automobile result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = automobileDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiorna(Automobile input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);
			proprieatarioDao.setConnection(connection);
			compagniaAssicurativaDao.setConnection(connection);
			
			//controllo che i dati di proprietario e compagnia assicurativa già esistano nel database
			try {
				
				
				if (proprieatarioDao.get(input.getProprietario().getId()) == null) {
					throw new Exception("Deve già esistere questo proprietario nel database");
				}

				if (compagniaAssicurativaDao.get(input.getCompagniaAssicurativa().getId()) == null) {
					throw new Exception("Deve già esistere questa compagnia assicurativa nel database");
				}
				
				
			} catch (Exception e) {
				System.out.println("La compagnia asssicurativa e il proprietario devono già esistere nel database");
				e.printStackTrace();
				throw e;
			}
			
			
			// eseguo quello che realmente devo fare
			result = automobileDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciNuovo(Automobile input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");
		
		
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);
			proprieatarioDao.setConnection(connection);
			compagniaAssicurativaDao.setConnection(connection);
			
			
			//controllo che i dati di proprietario e compagnia assicurativa già esistano nel database
			
				if ((proprieatarioDao.get(input.getProprietario().getId())) == null) {
					throw new Exception("Deve già esistere questo proprietario nel database");
				}

				if ((compagniaAssicurativaDao.get(input.getCompagniaAssicurativa().getId())) == null) {
					throw new Exception("Deve già esistere questa compagnia assicurativa nel database");
				}
			
				
			    
			

			// eseguo quello che realmente devo fare
			result = automobileDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuovi(Automobile input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);
			
		

			// eseguo quello che realmente devo fare
			result = automobileDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Automobile> findByExample(Automobile input) throws Exception {
		List<Automobile> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = automobileDao.findByExample(input);
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
	@Override
	public List<Automobile> automobiliConProprietarioCheHaPiuDiQuarantaAnni() throws Exception {
		List<Automobile> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			automobileDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = automobileDao.carsWithOwnerHasMoreThanFortyYears();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	

}
