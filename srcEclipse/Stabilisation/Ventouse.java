/**
*
*@author Flambard William Martin Johan
*/
package Stabilisation;

public class Ventouse extends MaterielTournageStabilisation{

	private double diametre;
	
	/**
	 * Constructeur Ventouse
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param diametre : diamètre de la ventouse
	 */
	public Ventouse(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock, double diametre) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.diametre = diametre;
	}
}
