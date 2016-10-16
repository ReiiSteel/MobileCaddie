/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class Reflecteur extends AccessoireLumiere{
	private double taille;
	
	/**
	 * Constructeur Reflecteur
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param taille : taille du reflecteur
	 */
	public Reflecteur(String nom, String reference, String modele,
			double prixLocationParJour, int stock, double taille) {
		
		super(nom, reference, modele, prixLocationParJour, stock);
		this.taille = taille;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}
	
}
