/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Trepied extends MaterielTournageStabilisation {

	private float hauteur;
	
	public Trepied(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, int hauteur) {
	
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.hauteur = hauteur;
	}
}
