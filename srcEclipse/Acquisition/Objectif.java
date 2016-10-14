/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;

public class Objectif extends DispositifAcquisition{

	public Objectif(String nom, String reference, String modele,
			double prixLocationParJour, int stock, String typeObjectif,
			int nbPixels, String resolution) {
		super(nom, reference, modele, prixLocationParJour, stock, typeObjectif,
				nbPixels, resolution);
	}
}
