/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class Reflecteur extends AccessoireLumiere{
	private double taille;
	

	public Reflecteur(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double taille) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
	}
	
}
