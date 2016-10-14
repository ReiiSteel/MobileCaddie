/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class FondStudio extends AccessoireLumiere{
	private double taille;
	private String couleur;
	
	public FondStudio(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double taille, String couleur) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
		this.couleur = couleur;
	}
}
