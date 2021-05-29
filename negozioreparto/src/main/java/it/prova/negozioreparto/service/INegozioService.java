package it.prova.negozioreparto.service;

import java.util.List;

import it.prova.negozioreparto.dao.INegozioDAO;
import it.prova.negozioreparto.model.Negozio;
import it.prova.negozioreparto.model.Reparto;

public interface INegozioService {

	public void setNegozioDAO(INegozioDAO negozioDAO);

	public List<Negozio> listAll() throws Exception;

	public Negozio caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Negozio negozioInstance) throws Exception;

	public void inserisciNuovo(Negozio negozioInstance) throws Exception;

	public void rimuovi(Negozio negozioInstance) throws Exception;

	public List<Reparto> tuttiRepartiDatoUnNegozio(Negozio negozioInstance) throws Exception;

	// METODI RICHIESTI

	public List<Negozio> listaNegoziConAddettoConDeterminatoCognome(String cognome) throws Exception;

}
