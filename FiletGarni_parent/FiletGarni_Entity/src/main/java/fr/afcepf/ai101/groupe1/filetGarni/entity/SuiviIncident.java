package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="suivi_incident")
public class SuiviIncident implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_suivi_incident", nullable=false)
	private Integer id;

	@Column(name="id_suivi_incident", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureDebut;

	@Column(name="id_suivi_incident", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureEstimeeFin;

	@Column(name="id_suivi_incident", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureFinReelle;

	@Column(name="id_suivi_incident", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heureAnnulation;

    @ManyToOne
    @JoinColumn(name="id_tourneetheorique_tsuiviincident", nullable=true, foreignKey=
    @ForeignKey(name="FK_tourneetheorique_tsuiviincident"))
    private TourneeTheorique tourneeTheorique;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(java.util.Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public java.util.Date getHeureEstimeeFin() {
		return heureEstimeeFin;
	}

	public void setHeureEstimeeFin(java.util.Date heureEstimeeFin) {
		this.heureEstimeeFin = heureEstimeeFin;
	}

	public java.util.Date getHeureFinReelle() {
		return heureFinReelle;
	}

	public void setHeureFinReelle(java.util.Date heureFinReelle) {
		this.heureFinReelle = heureFinReelle;
	}

	public java.util.Date getHeureAnnulation() {
		return heureAnnulation;
	}

	public void setHeureAnnulation(java.util.Date heureAnnulation) {
		this.heureAnnulation = heureAnnulation;
	}

	public TourneeTheorique getTourneeTheorique() {
		return tourneeTheorique;
	}

	public void setTourneeTheorique(TourneeTheorique tourneeTheorique) {
		this.tourneeTheorique = tourneeTheorique;
	}

	public SuiviIncident() {
    }

	public SuiviIncident(Integer id, Date heureDebut, Date heureEstimeeFin, Date heureFinReelle, Date heureAnnulation,
			TourneeTheorique tourneeTheorique) {
		super();
		this.id = id;
		this.heureDebut = heureDebut;
		this.heureEstimeeFin = heureEstimeeFin;
		this.heureFinReelle = heureFinReelle;
		this.heureAnnulation = heureAnnulation;
		this.tourneeTheorique = tourneeTheorique;
	}
    
    

}