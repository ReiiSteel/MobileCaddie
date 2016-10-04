/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Ventouse extends MaterielTournageStabilisation{

	private float diametre;
	
	public Ventouse(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, float diametre) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.diametre = diametre;
	}
}
