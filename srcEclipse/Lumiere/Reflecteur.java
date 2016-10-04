/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class Reflecteur extends AccessoireLumiere{
	private float taille;
	

	public Reflecteur(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, float taille) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
	}
	
}
