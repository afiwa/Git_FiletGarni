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

@Entity
@Table(name = "categorieproduit")
public class CategorieProduit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categorieproduit", nullable = false)
	private Integer id;

	@Column(name="libelle_categorieproduit", nullable = false, length = 50)
	private String libelle;

	@ManyToOne
	@JoinColumn(name = "id_categorie_tcategorie", nullable = true, 
	foreignKey = @ForeignKey(name = "FK_categorie_tcategorie"))
	private CategorieProduit categorie;

	@OneToMany(mappedBy = "categorie")
	private List<CategorieProduit> categories;

	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits;

	@OneToMany(mappedBy="categorie")
	private List<ProduitRecette> listeProduitRecette;

	public CategorieProduit() {
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

	public CategorieProduit getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieProduit paramCategorie) {
		categorie = paramCategorie;
	}

	public List<CategorieProduit> getCategories() {
		return categories;
	}

	public void setCategories(List<CategorieProduit> paramCategories) {
		categories = paramCategories;
	}


	public CategorieProduit(Integer paramId, String paramLibelle, CategorieProduit paramCategorie) {
		super();
		id = paramId;
		libelle = paramLibelle;
		categorie = paramCategorie;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> paramProduits) {
		produits = paramProduits;
	}

}