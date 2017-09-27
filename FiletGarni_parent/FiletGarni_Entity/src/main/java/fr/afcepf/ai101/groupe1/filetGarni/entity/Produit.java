package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {
   
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produit", nullable = false)
	private Integer id;
	
	@Column(name="photo_produit", nullable = true, length = 20)
    private String photo;
	
	@Column(name="libelle_produit", nullable = false, length = 50)
    private String libelle;
	
	@Column(name="prix_produit", nullable = false)
    private Double prix;
	
	@Column(name="description_produit", nullable = false, length = 500)
    private String description;
	
	@Column(name="quantitestock_produit", nullable = false)
    private Integer quantiteEnStock;
	
	@Column(name="date_creation_produit", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreationProduit;
	
	@ManyToMany
	@JoinTable(name = "conditionnement_produit", joinColumns = 
	@JoinColumn(name = "id_produit", referencedColumnName = "id_produit"),inverseJoinColumns = 
	@JoinColumn(name = "id_conditionnement", referencedColumnName = "id_conditionnement"))
    private List<Conditionnement> conditionnements;
    
    @ManyToOne
    @JoinColumn(name = "id_categorie_tproduit", nullable = true, 
    			foreignKey = @ForeignKey(name = "FK_categorie_tproduit"))
    private CategorieProduit categorie;
    
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> lgnCommandes;
    
    @ManyToOne
    @JoinColumn(name = "id_producteur_tproduit", nullable = true, foreignKey = 
    @ForeignKey(name = "FK_producteur_tproduit"))
    private Producteur producteur;
    
    public Produit() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String paramPhoto) {
		photo = paramPhoto;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double paramPrix) {
		prix = paramPrix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String paramDescription) {
		description = paramDescription;
	}

	public Integer getQuantiteEnStock() {
		return quantiteEnStock;
	}

	public void setQuantiteEnStock(Integer paramQuantiteEnStock) {
		quantiteEnStock = paramQuantiteEnStock;
	}

	public java.util.Date getDateCreationProduit() {
		return dateCreationProduit;
	}

	public void setDateCreationProduit(java.util.Date paramDateCreationProduit) {
		dateCreationProduit = paramDateCreationProduit;
	}

	public List<Conditionnement> getConditionnements() {
		return conditionnements;
	}

	public void setConditionnements(List<Conditionnement> paramConditionnements) {
		conditionnements = paramConditionnements;
	}

	public CategorieProduit getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieProduit paramCategorie) {
		categorie = paramCategorie;
	}

	
	public List<LigneCommande> getLgnCommandes() {
		return lgnCommandes;
	}

	public void setLgnCommandes(List<LigneCommande> paramLgnCommandes) {
		lgnCommandes = paramLgnCommandes;
	}

	public Producteur getProducteur() {
		return producteur;
	}

	public void setProducteur(Producteur paramProducteur) {
		producteur = paramProducteur;
	}

	public Produit(Integer paramId, String paramPhoto, String paramLibelle, Double paramPrix, String paramDescription,
			Integer paramQuantiteEnStock, Date paramDateCreationProduit, CategorieProduit paramCategorie, Producteur paramProducteur) {
		super();
		id = paramId;
		photo = paramPhoto;
		libelle = paramLibelle;
		prix = paramPrix;
		description = paramDescription;
		quantiteEnStock = paramQuantiteEnStock;
		dateCreationProduit = paramDateCreationProduit;
		categorie = paramCategorie;
		producteur = paramProducteur;
	}

	
}