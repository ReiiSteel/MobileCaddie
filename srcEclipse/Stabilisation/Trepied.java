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
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param hauteur : hauteur du trepied
	 */
	public Trepied(String nom, String reference, String modele,
			double prixLocationParJour, int stock, int hauteur) {
	
		super(nom, reference, modele, prixLocationParJour, stock);
		this.hauteur = hauteur;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
}
