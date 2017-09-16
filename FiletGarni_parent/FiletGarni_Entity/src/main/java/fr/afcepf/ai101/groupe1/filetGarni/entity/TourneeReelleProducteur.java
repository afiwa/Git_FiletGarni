package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("tourneeReelleProducteur")
public class TourneeReelleProducteur extends TourneeTheorique {

	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="tourneeReelleProducteur")
    private Livreur livreur;
    
    @OneToMany(mappedBy="tourneeReelleProducteur")
    private List<LigneCommande> lgnCommandes;
    
    
    public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur paramLivreur) {
		livreur = paramLivreur;
	}

	public List<LigneCommande> getLgnCommandes() {
		return lgnCommandes;
	}

	public void setLgnCommandes(List<LigneCommande> paramLgnCommandes) {
		lgnCommandes = paramLgnCommandes;
	}

	public TourneeReelleProducteur() {
    }

	public TourneeReelleProducteur(Integer id, String libelle, Date dateTournee, Integer nbKm, Date heureDebut,
			Date heureFin, Livreur livreur) {
		super(id, libelle, dateTournee, nbKm, heureDebut, heureFin);
		this.livreur = livreur;
	}

	
	

}