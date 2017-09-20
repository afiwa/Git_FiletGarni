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
@Table(name="periodeabsence")
public class PeriodeDAbsence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periode_absence", nullable=false)
    private Integer id;

	@Column(name="datedebut_periodeabsence", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateDebut;

	@Column(name="datefin_periodeabsence", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateFin;

	@Column(name="motif_periodeabsence", nullable=true, length=150)
    private String motif;

	@ManyToOne
	@JoinColumn(name="id_pointrelais", foreignKey=@ForeignKey(name="FK_pointrelais_tperiodeabsence"))
    private PointRelais pointRelais;

	@ManyToOne
	@JoinColumn(name="id_producteur", foreignKey=@ForeignKey(name="FK_producteur_tperiodeabsence"))
    private Producteur producteur;
    
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(java.util.Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public java.util.Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(java.util.Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public PointRelais getPointRelais() {
		return pointRelais;
	}

	public void setPointRelais(PointRelais pointRelais) {
		this.pointRelais = pointRelais;
	}

	public Producteur getProducteur() {
		return producteur;
	}

	public void setProducteur(Producteur producteur) {
		this.producteur = producteur;
	}

	public PeriodeDAbsence() {
    }

	public PeriodeDAbsence(Integer paramId, Date paramDateDebut, Date paramDateFin, String paramMotif,
			PointRelais paramPointRelais, Producteur paramProducteur) {
		super();
		id = paramId;
		dateDebut = paramDateDebut;
		dateFin = paramDateFin;
		motif = paramMotif;
		pointRelais = paramPointRelais;
		producteur = paramProducteur;
	}

	
	
	

}