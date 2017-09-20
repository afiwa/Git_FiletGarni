package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Adresse;
import fr.afcepf.ai101.groupe1.filetGarni.entity.CodePostal;
import fr.afcepf.ai101.groupe1.filetGarni.entity.Ville;

public interface IDaoAdresse {

    public java.util.List<Adresse> getByCP(CodePostal codePostal);
    public java.util.List<Adresse> getByVille(Ville ville);

}