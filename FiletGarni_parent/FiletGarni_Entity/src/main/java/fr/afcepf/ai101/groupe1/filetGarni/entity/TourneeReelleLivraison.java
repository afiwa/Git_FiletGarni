package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("tourneeReelleLivraison")
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

	public TourneeReelleLivraison(Integer id, String libelle, Date dateTournee, Integer nbKm, Date heureDebut,
			Date heureFin, Livreur livreur) {
		super(id, libelle, dateTournee, nbKm, heureDebut, heureFin);
		this.livreur = livreur;
	}

	
	
	
    
}