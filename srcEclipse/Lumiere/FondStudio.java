/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class FondStudio extends AccessoireLumiere{
	private float taille;
	private String couleur;
	
	public FondStudio(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, float taille, String couleur) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
		this.couleur = couleur;
		// TODO Auto-generated constructor stub
	}
	
	
	
}
