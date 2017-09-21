package fr.afcepf.ai101.filetGarni.data.api;

import fr.afcepf.ai101.groupe1.filetGarni.entity.Salarie;

public interface IDaoSalarie {

	public Salarie seConnecter (String identifiantConnexion, String paramMdp);
	
}