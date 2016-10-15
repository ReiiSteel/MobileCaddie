/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Trepied extends MaterielTournageStabilisation {

	private double hauteur;
	
	/**
	 * Constructeur Trepied
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param hauteur : hauteur du trepied
	 */
	public Trepied(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, int hauteur) {
	
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.hauteur = hauteur;
	}
}
