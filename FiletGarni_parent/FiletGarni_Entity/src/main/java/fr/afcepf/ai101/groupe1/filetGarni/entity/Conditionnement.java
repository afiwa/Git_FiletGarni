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
@Table(name = "conditionnement")
public class Conditionnement implements Serializable {  

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conditionnement", nullable = false)
	private Integer id;
	
	@Column(name="libelle_conditionnement", nullable = false, length = 50)
    private String libelle;
	
	@Column(name="quantite_conditionnement", nullable = false)
    private Double quantite;
	
	@Column(name="unite_conditionnement", nullable = false, length = 10)
    private String unite;
    
	@ManyToMany(mappedBy = "conditionnements")
    private List<Produit> produits;
    
    public Conditionnement() {
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

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double paramQuantite) {
		quantite = paramQuantite;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String paramUnite) {
		unite = paramUnite;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> paramProduits) {
		produits = paramProduits;
	}

	public Conditionnement(Integer paramId, String paramLibelle, Double paramQuantite, String paramUnite) {
		super();
		id = paramId;
		libelle = paramLibelle;
		quantite = paramQuantite;
		unite = paramUnite;
	}
    
}