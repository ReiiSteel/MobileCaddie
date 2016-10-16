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
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param longueur : longeur de la grue
	 */
	public Grue(String nom, String reference, String modele,
			double prixLocationParJour, int stock, double longueur) {
		super(nom, reference, modele, prixLocationParJour, stock);
		this.longueur = longueur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
}
