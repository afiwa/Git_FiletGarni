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
	
	@Column(name="quantite_produitrecette", nullable = false)
    private Double quantiteRecette;
	
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

	public Double getQuantiteRecette() {
		return quantiteRecette;
	}

	public void setQuantiteRecette(Double paramQuantiteRecette) {
		quantiteRecette = paramQuantiteRecette;
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

	public ProduitRecette(Integer paramId, Double paramQuantiteRecette) {
		super();
		id = paramId;
		quantiteRecette = paramQuantiteRecette;
	}
}