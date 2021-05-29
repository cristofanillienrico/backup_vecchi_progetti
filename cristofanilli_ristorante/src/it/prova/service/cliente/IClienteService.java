package it.prova.service.cliente;

import java.util.List;

import it.prova.dao.cliente.IClienteDAO;
import it.prova.dao.ristorante.IRistoranteDAO;
import it.prova.model.Cliente;

public interface IClienteService {

	// per injection
	public void setClienteDAO(IClienteDAO clienteDAO);
	
	public void setRistoranteDAO(IRistoranteDAO ristoranteDAO);

	public List<Cliente> listAllClienti() throws Exception;

	public Cliente caricaSingoloCliente(Long id) throws Exception;

	public void aggiorna(Cliente clienteInstance) throws Exception;

	public void inserisciNuovo(Cliente clienteInstance) throws Exception;

	public void rimuovi(Cliente clienteInstance) throws Exception;

	

}
