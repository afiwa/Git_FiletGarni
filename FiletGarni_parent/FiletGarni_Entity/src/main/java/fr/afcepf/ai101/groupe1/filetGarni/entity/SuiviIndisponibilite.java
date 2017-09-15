package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "suiviindispo")
public class SuiviIndisponibilite implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_suiviindispo", nullable = false)
	private Integer id;
	
	@Column(name="quantitereelle_suiviindispo", nullable = false)
    private Double quantiteReelle;
	
	@Column(name="date_suiviindispo", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateIndisponibilite;
	
	@OneToOne(mappedBy = "indispo")
    private LigneCommande lgnCommandes;
    
    public SuiviIndisponibilite() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public Double getQuantiteReelle() {
		return quantiteReelle;
	}

	public void setQuantiteReelle(Double paramQuantiteReelle) {
		quantiteReelle = paramQuantiteReelle;
	}

	public Date getDateIndisponibilite() {
		return dateIndisponibilite;
	}

	public void setDateIndisponibilite(Date paramDateIndisponibilite) {
		dateIndisponibilite = paramDateIndisponibilite;
	}

	public LigneCommande getLgnCommandes() {
		return lgnCommandes;
	}

	public void setLgnCommandes(LigneCommande paramLgnCommandes) {
		lgnCommandes = paramLgnCommandes;
	}

	public SuiviIndisponibilite(Integer paramId, Double paramQuantiteReelle, Date paramDateIndisponibilite) {
		super();
		id = paramId;
		quantiteReelle = paramQuantiteReelle;
		dateIndisponibilite = paramDateIndisponibilite;
	}    
}