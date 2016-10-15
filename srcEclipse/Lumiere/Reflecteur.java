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
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param taille : taille du reflecteur
	 */
	public Reflecteur(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double taille) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.taille = taille;
	}
	
}
