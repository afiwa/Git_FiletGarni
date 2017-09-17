package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "codepostal")
public class CodePostal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cp", nullable=false)
	private Integer id;
    
	@Column(name="code_postal_cp", nullable=false, length=10)
    private String codePostal;
   
	@Column(name="departement_cp", nullable=true, length=10)
    private String departement;
   
	@ManyToMany
	@JoinTable(name="codepostal_ville", joinColumns=
	@JoinColumn(name="id_cp", referencedColumnName="id_cp"), inverseJoinColumns=
	@JoinColumn(name="id_ville", referencedColumnName="id_ville"))
    private List<Ville> villes;
	
	@OneToMany(mappedBy="codePostal")
	private List<Adresse> adresses;
        

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public CodePostal() {
    }

	public CodePostal(Integer id, String codePostal, String departement) {
		super();
		this.id = id;
		this.codePostal = codePostal;
		this.departement = departement;
	}

	
	
	
	
    

   
}