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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "codepostal")
public class CodePostal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cp", nullable=false)
	private Integer id;
    
	@Column(name="code_commune_cp", nullable=false, length=10)
    private String codeCommune;

	@Column(name="code_postal_cp", nullable=false, length=10)
    private String codePostal;
   
	@Column(name="departement_cp", nullable=true, length=10)
    private Integer departement;
   
//	@OneToMany(mappedBy="codePostal")
	@Transient
    private List<Ville> villes;
    
	@ManyToOne
	@JoinColumn(name="id_region_tcodepostal", nullable=true, foreignKey=@ForeignKey(name="FK_region_tcodepostal"))
    private Region region;
    

    public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String paramCodeCommune) {
		codeCommune = paramCodeCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String paramCodePostal) {
		codePostal = paramCodePostal;
	}

	public Integer getDepartement() {
		return departement;
	}

	public void setDepartement(Integer paramDepartement) {
		departement = paramDepartement;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region paramRegion) {
		region = paramRegion;
	}

	public CodePostal() {
    }

	public CodePostal(Integer paramId, String paramCodeCommune, String paramCodePostal, Integer paramDepartement,
			Region paramRegion) {
		super();
		id = paramId;
		codeCommune = paramCodeCommune;
		codePostal = paramCodePostal;
		departement = paramDepartement;
		region = paramRegion;
	}
	
	
    

   
}