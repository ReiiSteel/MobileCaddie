/**
* Classe abstraite regroupant les attributs communs des matériels de tournage
*@author Flambard William Martin Johan
*/
package Stabilisation;

public abstract class MaterielTournageStabilisation extends main.Article {

	/**
	 * Constructeur MaterielTournageStabilisation
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 */
	public MaterielTournageStabilisation(String nom, String reference,
			String modele, double prixLocationParJour, int nbStock) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
	}

	
}
