package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tournee_Reelle_Livraison")
public class TourneeReelleLivraison extends TourneeTheorique {
	
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="tourneeReelleLivraison")
    private Livreur livreur;
    
	@OneToMany(mappedBy="tourneeReelleLivraison")
    private List<Commande> commandes;
	

    public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur paramLivreur) {
		livreur = paramLivreur;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> paramCommandes) {
		commandes = paramCommandes;
	}

	public TourneeReelleLivraison() {
    }

	public TourneeReelleLivraison(Livreur paramLivreur) {
		super();
		livreur = paramLivreur;
	}
	
	
    
}