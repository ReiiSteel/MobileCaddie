/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;

import main.Article;

public class Objectif extends Article {

	/**
	 * Constructeur Objectif
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 */
	public Objectif(String nom, String reference, String modele, double prixLocationParJour, int stock) {
		super(nom, reference, modele, prixLocationParJour, stock);
	}
}
