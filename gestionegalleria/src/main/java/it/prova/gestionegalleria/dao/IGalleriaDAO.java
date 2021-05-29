package it.prova.gestionegalleria.dao;

import java.util.List;

import it.prova.gestionegalleria.model.Galleria;
import it.prova.gestionegalleria.model.Quadro;
import it.prova.gestionegalleria.model.Tinta;

public interface IGalleriaDAO extends IBaseDAO<Galleria> {

	public List<Quadro> allQuadriByGalleria(Galleria galleriaInstance) throws Exception;

	public List<String> addressGallerieWhereUsedATinta(Tinta tintaInstance) throws Exception;

}
