package service.cd;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import dao.Constants;
import dao.cd.CdDAO;
import model.Autore;
import model.Cd;

public class CdServiceImpl implements CdService{
	
	private CdDAO cdDao;
	
	@Override
	public void setCdDao(CdDAO cdDao) {
		this.cdDao=cdDao;
		
	}

	@Override
	public List<Cd> listAll() throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public Cd findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");
		
		Cd result = null;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int aggiorna(Cd input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int inserisciNuovo(Cd input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");
		
		if(input.getAutore()==null) {
			throw new Exception("Non è stato implementato l'autore");
		}
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public int rimuovi(Cd input) throws Exception {
		if (input == null || input.getId() == null || input.getId() <1)
			throw new Exception("Valore di input non ammesso.");
		
		int result = 0;
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Cd> findByExample(Cd input) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Cd> trovaTuttiDaGenere(String genere) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByGenere(genere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	@Override
	public List<Cd> trovaTuttiDaAutoreDoveTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception {
		List<Cd> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = cdDao.findAllByAutoreWhereTitolStartsWith(autoreInput, iniziale);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

}
