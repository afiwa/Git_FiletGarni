package fr.afcepf.ai101.filetGarni.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai101.filetGarni.business.api.IBusinessAbsence;
import fr.afcepf.ai101.filetGarni.data.api.IDaoHorairesOuverture;
import fr.afcepf.ai101.filetGarni.data.api.IDaoJour;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPeriodeDAbsence;
import fr.afcepf.ai101.filetGarni.data.api.IDaoPointRelais;
import fr.afcepf.ai101.filetGarni.data.api.IDaoProducteur;
import fr.afcepf.ai101.groupe1.filetGarni.entity.PeriodeDAbsence;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

@Remote(IBusinessAbsence.class)
@Stateless
public class BusinessAbsence implements IBusinessAbsence {


    public BusinessAbsence() {
    }

    @EJB
    private IDaoProducteur daoProducteur;

    @EJB
    private IDaoPointRelais daoPointRelais;

    @EJB
    private IDaoPeriodeDAbsence daoPeriodeDAbsence;

    @EJB
    private IDaoJour daoJour;

    @EJB
    private IDaoHorairesOuverture daoHorairesOuverture;

    public java.util.List<PeriodeDAbsence> getAbsenceByUtilisateur(Utilisateur utilisateur) {
        // TODO implement here
        return null;
    }

    public PeriodeDAbsence addAbsenceByUtilisateur(Utilisateur utilisateur) {
        // TODO implement here
        return null;
    }

    public Boolean deleteAbsenceByAbsence(PeriodeDAbsence absence) {
        // TODO implement here
        return null;
    }

}