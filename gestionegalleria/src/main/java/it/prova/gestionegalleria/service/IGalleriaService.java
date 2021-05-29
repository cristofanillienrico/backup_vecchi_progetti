package it.prova.gestionegalleria.service;

import java.util.List;

import it.prova.gestionegalleria.dao.IGalleriaDAO;
import it.prova.gestionegalleria.model.Galleria;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public interface IGalleriaService {

	public void setGalleriaDAO(IGalleriaDAO galleriaDAO);

	public List<Galleria> listAll() throws Exception;

	public Galleria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Galleria galleriaInstance) throws Exception;

	public void inserisciNuovo(Galleria galleriaInstance) throws Exception;

	public void rimuovi(Galleria galleriaInstance) throws Exception;

	public List<Quadro> tuttiQuadriDataUnaGalleria(Galleria galleriaInstance) throws Exception;

	public void aggiungiQuadro(Galleria galleriaInstance, Quadro quadroInstance) throws Exception;

	// richiesti
	public List<String> indirizziGallerieDoveUsataCertaTinta(Tinta tintaInstance) throws Exception;

}
