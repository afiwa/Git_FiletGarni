package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Region;

public interface IDaoRegion {

    public java.util.List<Region> getByNom(String nom);

}