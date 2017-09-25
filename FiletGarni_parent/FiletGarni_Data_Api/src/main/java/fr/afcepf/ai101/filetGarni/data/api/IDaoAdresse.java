package fr.afcepf.ai101.filetGarni.data.api;

import java.util.List;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Adresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.NonSalarie;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

public interface IDaoAdresse {

    public java.util.List<Adresse> getByCP(CodePostal codePostal);
    
    public java.util.List<Adresse> getByVille(Ville ville);
    
    public List<Adresse> getByNonSalarie(NonSalarie nonSalarie);

}