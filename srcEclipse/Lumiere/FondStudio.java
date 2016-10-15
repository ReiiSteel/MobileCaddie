/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class FondStudio extends AccessoireLumiere{
	private double taille;
	private String couleur;
	
	/**
	 * Constructeur FondStudio
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param taille : taille du fond de studio
	 * @param couleur : couleur du fond de studio
	 */
	public FondStudio(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double taille, String couleur) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
		this.couleur = couleur;
	}
}
