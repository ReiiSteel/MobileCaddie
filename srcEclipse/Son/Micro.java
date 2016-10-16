package Son;

import main.Article;

/**
*
*@author Flambard William Martin Johan
*/
public class Micro extends Article {

	/**
	 * Constructeur Micro
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 */
	public Micro(String nom, String reference, String modele,
			double prixLocationParJour, int stock) {
		super(nom, reference, modele, prixLocationParJour, stock);
	}

}
