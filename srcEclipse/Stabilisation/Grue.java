/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Grue extends MaterielTournageStabilisation {
	private double longueur;
	

	public Grue(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double longueur) {
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.longueur = longueur;
	}
}
