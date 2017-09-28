package fr.afcepf.ai101.filetGarni.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoAdresse;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCodePostal;
import fr.afcepf.ai101.filetGarni.data.api.IDaoCommande;
import fr.afcepf.ai101.filetGarni.data.api.IDaoHorairesOuverture;
import fr.afcepf.ai101.filetGarni.data.api.IDaoJour;
import fr.afcepf.ai101.filetGarni.data.api.IDaoNonSalarie;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPeriodeDAbsence;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProfessionnel;
import fr.afcepf.ai101.filetGarni.data.api.IDaoRegion;
import fr.afcepf.ai101.filetGarni.data.api.IDaoVille;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Commande;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PointRelais;

@Remote(IBusinessPointRelais.class)
@Stateless
public class BusinessPointRelais implements IBusinessPointRelais {

    public BusinessPointRelais() {
    }

    @EJB
    private IDaoRegion daoRegion;

    @EJB
    private IDaoHorairesOuverture daoHorairesOuverture;

    @EJB
    private IDaoJour daoJour;

    @EJB
    private IDaoPointRelais daoPointRelais;

    @EJB
    private IDaoProfessionnel daoProfessionnel;

    @EJB
    private IDaoNonSalarie daoNonSalarie;

    @EJB
    private IDaoPeriodeDAbsence daoPeriodeDAbsence;

    @EJB
    private IDaoAdresse daoAdresse;

    @EJB
    private IDaoVille daoVille;

    @EJB
    private IDaoCommande daoCommande;

    @EJB
    private IDaoCodePostal daoCodePostal;

    public java.util.List<Commande> afficherCommandesLivrees(PointRelais pointRelais) {
        // TODO implement here
    	List<Commande> commandes = new ArrayList<>();
    	
    	commandes = daoPointRelais.getCommandesByIdPointRelais(pointRelais.getId());
   
        return commandes;
    }
    
    public PointRelais getPointRelaisByID(Integer id_PointRelais) {
    	return daoPointRelais.getById(id_PointRelais);
    }
   
    public Commande validerRecuperationConsommateur(Integer id_commande) {
        // TODO implement here
        return null;
    }
    
    

}