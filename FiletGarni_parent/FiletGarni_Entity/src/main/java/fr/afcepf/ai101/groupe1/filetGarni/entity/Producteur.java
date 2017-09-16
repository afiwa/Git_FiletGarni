package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("producteur")
public class Producteur extends Professionnel {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "descriptionbreve_producteur", nullable = false, length = 200)
	private String descriptionBreve;
	
	@Column(name = "descriptiondetaillee_producteur", nullable = false, length = 1000)
    private String descriptionDetaillee;
	
	@Column(name = "photo_producteur", nullable = false, length = 20)
    private String photo;
    
	@OneToMany(mappedBy = "producteur")	
    private List<Produit> produits;
	
	@ManyToMany
	@JoinTable(name = "categorie_producteur",
				joinColumns = @JoinColumn(name = "id_producteur", referencedColumnName = "id_producteur"),
				inverseJoinColumns = @JoinColumn(name = "id_categorieproducteur", 
				referencedColumnName = "id_categorieproducteur"))
    private List<CategorieProducteur> categories;
	
	@OneToMany(mappedBy = "producteur")
    private List<PeriodeDAbsence> periodeAbsences;
    
    public Producteur() {
    }
    
    
    public String getDescriptionBreve() {
		return descriptionBreve;
	}


	public void setDescriptionBreve(String paramDescriptionBreve) {
		descriptionBreve = paramDescriptionBreve;
	}


	public String getDescriptionDetaillee() {
		return descriptionDetaillee;
	}


	public void setDescriptionDetaillee(String paramDescriptionDetaillee) {
		descriptionDetaillee = paramDescriptionDetaillee;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String paramPhoto) {
		photo = paramPhoto;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> paramProduits) {
		produits = paramProduits;
	}


	public List<CategorieProducteur> getCategories() {
		return categories;
	}


	public void setCategories(List<CategorieProducteur> paramCategories) {
		categories = paramCategories;
	}


	public List<PeriodeDAbsence> getPeriodeAbsences() {
		return periodeAbsences;
	}


	public void setPeriodeAbsences(List<PeriodeDAbsence> paramPeriodeAbsences) {
		periodeAbsences = paramPeriodeAbsences;
	}


	public Producteur(String paramDescriptionBreve, String paramDescriptionDetaillee, String paramPhoto) {
		super();
		descriptionBreve = paramDescriptionBreve;
		descriptionDetaillee = paramDescriptionDetaillee;
		photo = paramPhoto;
	}


	public void getVentesMois() {
        // TODO implement here
    }
    public void getNbCmdeByMois() {
        // TODO implement here
    }
    public void getNbArticleVenduByMois() {
        // TODO implement here
    }
    public void getCAMensuel() {
        // TODO implement here
    }
    public void getCAAnnuel() {
        // TODO implement here
    }

}