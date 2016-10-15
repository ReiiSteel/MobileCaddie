/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;

public class AppareilPhoto extends DispositifAcquisition {
	/**
	 * Constructeur AppareilPhoto
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param typeObjectif : type d'objectif de l'article
	 * @param nbPixels : nombre de pixel de l'appareil
	 * @param resolution : résolution de l'appareil
	 */
	public AppareilPhoto(String nom, String reference, String marque,
			double prixLocationParJour, int stock, String typeObjectif,
			int nbPixels, String resolution) {
		super(nom, reference, marque, prixLocationParJour, stock, typeObjectif,
				nbPixels, resolution);
	}

	

}
