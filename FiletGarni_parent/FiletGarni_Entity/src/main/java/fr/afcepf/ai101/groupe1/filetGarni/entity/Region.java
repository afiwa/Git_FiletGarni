package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="region")
public class Region implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_region", nullable=false)
    private Integer id;
    
	@Column(name="libelle_region", nullable=false, length=50)
    private String libelle;
   
    @OneToMany(mappedBy="region")
    private List<CodePostal> codePostaux;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<CodePostal> getCodePostaux() {
		return codePostaux;
	}

	public void setCodePostaux(List<CodePostal> codePostaux) {
		this.codePostaux = codePostaux;
	}

	public Region() {
    }

	public Region(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	

}