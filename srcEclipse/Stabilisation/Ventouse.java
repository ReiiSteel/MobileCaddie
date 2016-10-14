/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Ventouse extends MaterielTournageStabilisation{

	private double diametre;
	
	public Ventouse(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double diametre) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.diametre = diametre;
	}
}
