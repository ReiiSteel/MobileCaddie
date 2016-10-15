/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

/**
 * Classe abstraite représentant les attributs communs des accessoires de lumieres 
 *@author Flambard William Martin Johan
 *
 */
public abstract class AccessoireLumiere extends main.Article {

	/**
	 * Constructeur Accessoire Lumiere
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 */
	public AccessoireLumiere(String nom, String reference, String modele,
			double prixLocationParJour, int nbStock) {
		super(nom, reference, modele, prixLocationParJour, nbStock);
	}

	
}
