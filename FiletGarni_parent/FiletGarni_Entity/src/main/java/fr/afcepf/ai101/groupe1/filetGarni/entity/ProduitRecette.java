package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produitrecette")
public class ProduitRecette implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produitrecette", nullable = false)
	private Integer id;
	@Column(name="libelle_produitrecette", nullable = false, length=50)
	private String libelle;
	
	@Column(name="quantite_produitrecette", nullable = false, length=50)
    private String quantiteRecette;
	
	@OneToMany(mappedBy = "produitRecette")
    private List<Produit> produits;
    
    @ManyToMany(mappedBy = "produitRecettes")
    private List<Recette> recettes;
    
    public ProduitRecette() {
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

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getQuantiteRecette() {
		return quantiteRecette;
	}

	public void setQuantiteRecette(String quantiteRecette) {
		this.quantiteRecette = quantiteRecette;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> paramProduits) {
		produits = paramProduits;
	}

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> paramRecettes) {
		recettes = paramRecettes;
	}

	public ProduitRecette(Integer paramId, String paramLibelle, String paramQuantiteRecette) {
		super();
		id = paramId;
		libelle = paramLibelle;
		quantiteRecette = paramQuantiteRecette;
	}

	
}