/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Grue extends MaterielTournageStabilisation {
	private double longueur;
	
	/**
	 * Constructeur Grue
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param longueur : longeur de la grue
	 */
	public Grue(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double longueur) {
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.longueur = longueur;
	}
}
