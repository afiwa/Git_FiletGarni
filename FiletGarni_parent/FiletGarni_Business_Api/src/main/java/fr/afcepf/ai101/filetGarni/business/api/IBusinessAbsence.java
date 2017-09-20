package fr.afcepf.ai101.filetGarni.business.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.PeriodeDAbsence;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Utilisateur;

public interface IBusinessAbsence {

    public java.util.List<PeriodeDAbsence> getAbsenceByUtilisateur(Utilisateur utilisateur);

    public PeriodeDAbsence addAbsenceByUtilisateur(Utilisateur utilisateur);

    public Boolean deleteAbsenceByAbsence(PeriodeDAbsence absence);

}