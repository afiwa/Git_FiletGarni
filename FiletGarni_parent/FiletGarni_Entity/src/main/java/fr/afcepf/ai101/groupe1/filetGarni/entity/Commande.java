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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_commande", nullable = false)
	private Integer id;
	
	@Column(name = "date_creation_commande", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreationCommande;
	
	@Column(name = "date_paiement_commande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date datePaiement;
	
	@Column(name = "date_validation_commande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateValidation;
	
	@Column(name = "date_livraisonreelle_commande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateLivraisonReelle;
	
	@Column(name = "date_livraisonprevue_commande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateLivraisonPrevue;
	
	@Column(name = "date_recuperationclient_commande", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateRecuperationClient;
	
	@Column(name = "typepaiement_commande", nullable = true, length = 50)
    private TypePaiement typePaiement;
	
	// TODO OneToOne
    private Evaluation evaluation;
	
	// TODO OneToMany
    private List<LigneCommande> lgnCommandes;
    
    // TODO ManyToOne
    private PointRelais pointRelais;
    
    @ManyToOne
    @JoinColumn(name = "id_consommateur_tcommande", nullable = true, foreignKey = @ForeignKey(name = "FK_consommateur_tcommande"))
    private Consommateur consommateur;
    
    // TODO ManyToOne
    private TourneeReelleLivraison tourneeReelleLivraison;

    public Commande() {
    }
    
    public void getMontantCmde() {
        // TODO implement here
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public java.util.Date getDateCreationCommande() {
		return dateCreationCommande;
	}

	public void setDateCreationCommande(java.util.Date paramDateCreationCommande) {
		dateCreationCommande = paramDateCreationCommande;
	}

	public java.util.Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(java.util.Date paramDatePaiement) {
		datePaiement = paramDatePaiement;
	}

	public java.util.Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(java.util.Date paramDateValidation) {
		dateValidation = paramDateValidation;
	}

	public java.util.Date getDateLivraisonReelle() {
		return dateLivraisonReelle;
	}

	public void setDateLivraisonReelle(java.util.Date paramDateLivraisonReelle) {
		dateLivraisonReelle = paramDateLivraisonReelle;
	}

	public java.util.Date getDateLivraisonPrevue() {
		return dateLivraisonPrevue;
	}

	public void setDateLivraisonPrevue(java.util.Date paramDateLivraisonPrevue) {
		dateLivraisonPrevue = paramDateLivraisonPrevue;
	}

	public java.util.Date getDateRecuperationClient() {
		return dateRecuperationClient;
	}

	public void setDateRecuperationClient(java.util.Date paramDateRecuperationClient) {
		dateRecuperationClient = paramDateRecuperationClient;
	}

	public TypePaiement getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(TypePaiement paramTypePaiement) {
		typePaiement = paramTypePaiement;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation paramEvaluation) {
		evaluation = paramEvaluation;
	}

	public List<LigneCommande> getLgnCommandes() {
		return lgnCommandes;
	}

	public void setLgnCommandes(List<LigneCommande> paramLgnCommandes) {
		lgnCommandes = paramLgnCommandes;
	}

	public PointRelais getPointRelais() {
		return pointRelais;
	}

	public void setPointRelais(PointRelais paramPointRelais) {
		pointRelais = paramPointRelais;
	}

	public Consommateur getConsommateur() {
		return consommateur;
	}

	public void setConsommateur(Consommateur paramConsommateur) {
		consommateur = paramConsommateur;
	}

	public TourneeReelleLivraison getTourneeReelleLivraison() {
		return tourneeReelleLivraison;
	}

	public void setTourneeReelleLivraison(TourneeReelleLivraison paramTourneeReelleLivraison) {
		tourneeReelleLivraison = paramTourneeReelleLivraison;
	}

	public Commande(Integer paramId, Date paramDateCreationCommande, Date paramDatePaiement, Date paramDateValidation,
			Date paramDateLivraisonReelle, Date paramDateLivraisonPrevue, Date paramDateRecuperationClient,
			TypePaiement paramTypePaiement, Evaluation paramEvaluation, PointRelais paramPointRelais,
			Consommateur paramConsommateur, TourneeReelleLivraison paramTourneeReelleLivraison) {
		super();
		id = paramId;
		dateCreationCommande = paramDateCreationCommande;
		datePaiement = paramDatePaiement;
		dateValidation = paramDateValidation;
		dateLivraisonReelle = paramDateLivraisonReelle;
		dateLivraisonPrevue = paramDateLivraisonPrevue;
		dateRecuperationClient = paramDateRecuperationClient;
		typePaiement = paramTypePaiement;
		evaluation = paramEvaluation;
		pointRelais = paramPointRelais;
		consommateur = paramConsommateur;
		tourneeReelleLivraison = paramTourneeReelleLivraison;
	}            
}