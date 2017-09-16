package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorieproducteur")
public class CategorieProducteur implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categorieproducteur", nullable = false)
	private Integer id;
	
	@Column(name="libelle_categorieproducteur", nullable = false, length = 150)
    private String libelle;
	
	@ManyToMany(mappedBy = "categories")
    private List<Producteur> producteurs;
    
    public CategorieProducteur() {
    }

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

	public List<Producteur> getProducteurs() {
		return producteurs;
	}

	public void setProducteurs(List<Producteur> paramProducteurs) {
		producteurs = paramProducteurs;
	}

	public CategorieProducteur(Integer paramId, String paramLibelle) {
		super();
		id = paramId;
		libelle = paramLibelle;
	}
        	
}