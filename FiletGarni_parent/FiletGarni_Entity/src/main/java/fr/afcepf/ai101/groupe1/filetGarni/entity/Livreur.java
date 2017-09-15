package fr.afcepf.ai101.groupe1.filetGarni.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="livreur")
public class Livreur extends Salarie {
    
	private static final long serialVersionUID = 1L;

	@OneToOne
	private TourneeReelleProducteur tourneeReelleProducteur;

    @OneToOne
    private TourneeReelleLivraison tourneeReelleLivraison;
    
    @OneToMany(mappedBy="livreur")
    private List<Ville> villes;
    
    
    public TourneeReelleProducteur getTourneeReelleProducteur() {
		return tourneeReelleProducteur;
	}

	public void setTourneeReelleProducteur(TourneeReelleProducteur paramTourneeReelleProducteur) {
		tourneeReelleProducteur = paramTourneeReelleProducteur;
	}

	public TourneeReelleLivraison getTourneeReelleLivraison() {
		return tourneeReelleLivraison;
	}

	public void setTourneeReelleLivraison(TourneeReelleLivraison paramTourneeReelleLivraison) {
		tourneeReelleLivraison = paramTourneeReelleLivraison;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}

	public Livreur() {
    }

	public Livreur(TourneeReelleProducteur paramTourneeReelleProducteur,
			TourneeReelleLivraison paramTourneeReelleLivraison) {
		super();
		tourneeReelleProducteur = paramTourneeReelleProducteur;
		tourneeReelleLivraison = paramTourneeReelleLivraison;
	}


}