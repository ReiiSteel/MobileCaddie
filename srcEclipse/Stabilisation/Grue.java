/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Grue extends MaterielTournageStabilisation {
	private float longueur;
	

	public Grue(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, float longueur) {
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.longueur = longueur;
	}
}
