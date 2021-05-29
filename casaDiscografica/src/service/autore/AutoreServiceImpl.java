package service.autore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import dao.Constants;
import dao.autore.AutoreDAO;
import dao.cd.CdDAO;
import model.Autore;
import model.CasaDiscografica;
import model.Cd;
import service.MyServiceFactory;
import service.casadiscografica.CasaDiscograficaService;
import service.cd.CdService;

public class AutoreServiceImpl implements AutoreService {
	
	private AutoreDAO autoreDao;
	private CdDAO cdDAO;

	

	@Override
	public void setAutoreDao(AutoreDAO autoreDao) {
		this.autoreDao=autoreDao;
	}
	
	@Override
	public void setCdDao(CdDAO cdDao) {
		this.cdDAO = cdDao;
	}

	@Override
	public List<Autore> listAll() throws Exception {
		List<Autore> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Autore findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");
		
		Autore result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiorna(Autore input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciNuovo(Autore input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");
		
		
		if(input.getCasaDiscografica()==null) {
			throw new Exception("All'autore non è stata assegnata una casa discografica");
		}
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuovi(Autore input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);
			cdDAO.setConnection(connection);
			
			autoreDao.populateCd(input);
			if(input.getListaCd().size() > 0 ) {
				for(Cd cdItem : input.getListaCd()) {
					cdDAO.delete(cdItem);
				}
			}

			// eseguo quello che realmente devo fare
			result = autoreDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Autore> findByExample(Autore input) throws Exception {
		List<Autore> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public void popolaCd(Autore input) throws Exception {
		if (input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");
		
		
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			autoreDao.populateCd(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		
		
	}

	@Override
	public List<Autore> trovaTuttiPerCasaDiscografica(CasaDiscografica input) throws Exception {
		List<Autore> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findAllByCasaDiscografica(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Autore> trovaConCdDoveTracceMaggioriDi(int nTracce) throws Exception {
		List<Autore> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findByCdWhereNTracceGraterThen(nTracce);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	
		
	}

