package it.prova.service.compagniaassicurativa;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.compagniaassicurativa.ICompagniaAssicurativaDAO;
import it.prova.model.CompagniaAssicurativa;

public class CompagniaAssicurativaServiceImpl implements ICompagniaAssicurativaService {

	private ICompagniaAssicurativaDAO compagniaAssicurativaDao;

	@Override
	public void setCompagniaAssicurativaDao(ICompagniaAssicurativaDAO compagniaAssicurativaDao) {
		this.compagniaAssicurativaDao = compagniaAssicurativaDao;

	}

	@Override
	public List<CompagniaAssicurativa> listAll() throws Exception {
		List<CompagniaAssicurativa> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public CompagniaAssicurativa findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		CompagniaAssicurativa result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiorna(CompagniaAssicurativa input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(CompagniaAssicurativa input) throws Exception {

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuovi(CompagniaAssicurativa input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			compagniaAssicurativaDao.populateAutomobili(input);
			if (input.getListaAutomobili().size() > 0) {
				throw new Exception("Per essere eliminata non deve contenere Automobili");
			}

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CompagniaAssicurativa> findByExample(CompagniaAssicurativa input) throws Exception {
		List<CompagniaAssicurativa> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			compagniaAssicurativaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = compagniaAssicurativaDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
