package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lignecommande")
public class LigneCommande implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_lignecommande", nullable = false)
	private Integer id;
	
	@Column(name="quantitecommande_lignecommande", nullable = false)
    private Double quantiteCommandee;
	
	@Column(name="quantitelivree_lignecommande", nullable = true)
    private Double quantiteLivree;
	
	@Column(name="date_validationprepproducteur_lignecommande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateValidationPreparationProducteur;
	
	@Column(name="date_validationrecuplivreur_lignecommande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateRecuperationLivreur;
	
	@Column(name="date_validationrecupclient_lignecommande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateRecuperationClient;
	
	@ManyToOne
	@JoinColumn(name = "id_commande_tlignecommande", nullable = true, 
				foreignKey = @ForeignKey(name = "FK_commande_tlignecommande"))
    private Commande commande;
    
    @ManyToOne
    @JoinColumn(name = "id_produit_tlignecommande", nullable = false, 
	foreignKey = @ForeignKey(name = "FK_produit_tlignecommande"))
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "id_tourneeproducteur_tlignecommande", nullable = true, 
    			foreignKey = @ForeignKey(name = "FK_tourneeproducteur_tlignecommande"))
    private TourneeReelleProducteur tourneeReelleProducteur;
    
    @OneToOne
    private SuiviIndisponibilite indispo;
    
    public LigneCommande() {
    }
    
    
    
    public Integer getId() {
		return id;
	}



	public void setId(Integer paramId) {
		id = paramId;
	}

	public Double getQuantiteCommandee() {
		return quantiteCommandee;
	}

	public void setQuantiteCommandee(Double paramQuantiteCommandee) {
		quantiteCommandee = paramQuantiteCommandee;
	}

	public Double getQuantiteLivree() {
		return quantiteLivree;
	}

	public void setQuantiteLivree(Double paramQuantiteLivree) {
		quantiteLivree = paramQuantiteLivree;
	}

	public java.util.Date getDateValidationPreparationProducteur() {
		return dateValidationPreparationProducteur;
	}



	public void setDateValidationPreparationProducteur(java.util.Date paramDateValidationPreparationProducteur) {
		dateValidationPreparationProducteur = paramDateValidationPreparationProducteur;
	}



	public java.util.Date getDateRecuperationLivreur() {
		return dateRecuperationLivreur;
	}

	public void setDateRecuperationLivreur(java.util.Date paramDateRecuperationLivreur) {
		dateRecuperationLivreur = paramDateRecuperationLivreur;
	}

	public java.util.Date getDateRecuperationClient() {
		return dateRecuperationClient;
	}

	public void setDateRecuperationClient(java.util.Date paramDateRecuperationClient) {
		dateRecuperationClient = paramDateRecuperationClient;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande paramCommande) {
		commande = paramCommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit paramProduit) {
		produit = paramProduit;
	}

	public TourneeReelleProducteur getTourneeReelleProducteur() {
		return tourneeReelleProducteur;
	}

	public void setTourneeReelleProducteur(TourneeReelleProducteur paramTourneeReelleProducteur) {
		tourneeReelleProducteur = paramTourneeReelleProducteur;
	}

	public SuiviIndisponibilite getIndispo() {
		return indispo;
	}

	public void setIndispo(SuiviIndisponibilite paramIndispo) {
		indispo = paramIndispo;
	}

	public LigneCommande(Integer paramId, Double paramQuantiteCommandee, Double paramQuantiteLivree,
			Date paramDateValidationPreparationProducteur, Date paramDateRecuperationLivreur,
			Date paramDateRecuperationClient, Commande paramCommande, Produit paramProduit,
			TourneeReelleProducteur paramTourneeReelleProducteur, SuiviIndisponibilite paramIndispo) {
		super();
		id = paramId;
		quantiteCommandee = paramQuantiteCommandee;
		quantiteLivree = paramQuantiteLivree;
		dateValidationPreparationProducteur = paramDateValidationPreparationProducteur;
		dateRecuperationLivreur = paramDateRecuperationLivreur;
		dateRecuperationClient = paramDateRecuperationClient;
		commande = paramCommande;
		produit = paramProduit;
		tourneeReelleProducteur = paramTourneeReelleProducteur;
		indispo = paramIndispo;
	}
	
	public LigneCommande(Integer paramId, Double paramQuantiteCommandee, Commande paramCommande, Produit paramProduit) {
		super();
		id = paramId;
		quantiteCommandee = paramQuantiteCommandee;
		commande = paramCommande;
		produit = paramProduit;
	}
	
	public LigneCommande(Integer paramId, Double paramQuantiteCommandee, Produit paramProduit) {
		super();
		id = paramId;
		quantiteCommandee = paramQuantiteCommandee;
		produit = paramProduit;
	}


	public Double getMontantLgnCommande(Double paramPrix) {
        return (produit.getPrix())*quantiteCommandee;
    }

}