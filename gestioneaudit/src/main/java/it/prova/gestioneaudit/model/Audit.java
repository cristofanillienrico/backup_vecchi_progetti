package it.prova.gestioneaudit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "descrizione_operazione")
	private String descrizioneOperazione;

	@Enumerated(EnumType.STRING)
	@Column(name = "codice_esito_operazione")
	private CodiceEsitoOperazione codiceEsitoOperazione;

	@Column(name = "messaggio_errore_eventuale")
	private String messaggioErroreEventuale;

	@Column(name = "date_created")
	private Date dateCreated;

	// invece di @OneToOne metto @ManyToOne , anche se è un one to one conviene fare
	// così al livello implementativo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;

	public Audit() {
		super();
	}

	public Audit(String descrizioneOperazione, CodiceEsitoOperazione codiceEsitoOperazione,
			String messaggioErroreEventuale, Date dateCreated, Utente utente) {
		super();
		this.descrizioneOperazione = descrizioneOperazione;
		this.codiceEsitoOperazione = codiceEsitoOperazione;
		this.messaggioErroreEventuale = messaggioErroreEventuale;
		this.dateCreated = dateCreated;
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizioneOperazione() {
		return descrizioneOperazione;
	}

	public void setDescrizioneOperazione(String descrizioneOperazione) {
		this.descrizioneOperazione = descrizioneOperazione;
	}

	public CodiceEsitoOperazione getCodiceEsitoOperazione() {
		return codiceEsitoOperazione;
	}

	public void setCodiceEsitoOperazione(CodiceEsitoOperazione codiceEsitoOperazione) {
		this.codiceEsitoOperazione = codiceEsitoOperazione;
	}

	public String getMessaggioErroreEventuale() {
		return messaggioErroreEventuale;
	}

	public void setMessaggioErroreEventuale(String messaggioErroreEventuale) {
		this.messaggioErroreEventuale = messaggioErroreEventuale;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Audit [id=" + id + ", descrizioneOperazione=" + descrizioneOperazione + ", codiceEsitoOperazione="
				+ codiceEsitoOperazione + ", messaggioErroreEventuale=" + messaggioErroreEventuale + ", dateCreated="
				+ dateCreated + "]";
	}

}
