/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;
public class Camera extends DispositifAcquisition {

	/**
	 * Constructeur Camera
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param typeObjectif : type d'objectif de l'article
	 * @param nbPixels : nombre de pixel de l'appareil
	 * @param resolution : résolution de l'appareil
	 */
	public Camera(String nom, String reference, String modele,
			double prixLocationParJour, int stock, String typeObjectif,
			int nbPixels, String resolution) {
		
		super(nom, reference, modele, prixLocationParJour, stock, typeObjectif,
				nbPixels, resolution);
	}
	

}
