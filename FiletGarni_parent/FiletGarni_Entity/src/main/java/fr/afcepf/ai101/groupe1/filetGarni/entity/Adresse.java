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
	
	@Column(name="numerorue_adresse", nullable = false, length = 5)
    private String numeroRue;
	
	@Column(name="latitude_adresse", nullable = false, length = 30)
    private String latitude;
	
	@Column(name="longitude_adresse", nullable = false, length = 30)
    private String longitude;
	
	@ManyToOne
	@JoinColumn(name = "id_ville_tadresse", nullable = true, foreignKey = @ForeignKey(name = "FK_ville_tadresse"))
    private Ville ville;
	
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville paramVille) {
		ville = paramVille;
	}
	public List<NonSalarie> getNonSalaries() {
		return nonSalaries;
	}
	public void setNonSalaries(List<NonSalarie> paramNonSalaries) {
		nonSalaries = paramNonSalaries;
	}

	public Adresse(Integer paramId, String paramLibelle, String paramNumeroRue, String paramLatitude,
			String paramLongitude, Ville paramVille) {
		super();
		id = paramId;
		libelle = paramLibelle;
		numeroRue = paramNumeroRue;
		latitude = paramLatitude;
		longitude = paramLongitude;
		ville = paramVille;
	}
        
    public Adresse() {
    }   
}