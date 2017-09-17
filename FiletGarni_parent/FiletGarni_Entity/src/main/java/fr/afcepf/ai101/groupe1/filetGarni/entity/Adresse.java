package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_adresse", nullable = false)
	private Integer id;
	
	@Column(name="libelle_adresse", nullable = true, length = 50)
    private String libelle;
	
	@Column(name="numerorue_adresse", nullable = true, length = 5)
    private String numeroRue;
	
	@Column(name="nomrue_adresse", nullable = false, length = 150)
    private String nomRue;
	
	@Column(name="latitude_adresse", nullable = false, length = 30)
    private String latitude;
	
	@Column(name="longitude_adresse", nullable = false, length = 30)
    private String longitude;
	
	@ManyToOne
	@JoinColumn(name = "id_codepostal_tadresse", nullable = true, foreignKey = @ForeignKey(name = "FK_codepostal_tadresse"))
    private CodePostal codePostal;
	
	@ManyToMany(mappedBy = "adresses")
    private List<NonSalarie> nonSalaries;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer paramId) {
		id = paramId;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}
	public String getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(String paramNumeroRue) {
		numeroRue = paramNumeroRue;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String paramLatitude) {
		latitude = paramLatitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String paramLongitude) {
		longitude = paramLongitude;
	}
	
	public List<NonSalarie> getNonSalaries() {
		return nonSalaries;
	}
	public void setNonSalaries(List<NonSalarie> paramNonSalaries) {
		nonSalaries = paramNonSalaries;
	}
	    
    public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public CodePostal getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(CodePostal codePostal) {
		this.codePostal = codePostal;
	}
	public Adresse() {
    }
    
	public Adresse(Integer id, String libelle, String numeroRue, String nomRue, String latitude, String longitude,
			CodePostal codePostal) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.latitude = latitude;
		this.longitude = longitude;
		this.codePostal = codePostal;
	}   
    
    
}