/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;
/**
 * Classe abstraite qui regroupe les attributs/méthodes communes d'un dispositif d'acquisition
 */
public abstract class DispositifAcquisition extends main.Article {
	
	private String typeObjectif;
	private int nbMillionsPixels;
	private String resolution;
	
	/**
	 * Constructeur de dispositif acquisition
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param typeObjectif : type d'objectif de l'article
	 * @param nbPixels : nombre de pixel de l'appareil
	 * @param resolution : résolution de l'appareil
	 */
	public DispositifAcquisition(String nom, String reference, String modele, double prixLocationParJour, int stock,
			String typeObjectif, int nbPixels, String resolution) {
		super(nom, reference, modele, prixLocationParJour, stock);
		this.nbMillionsPixels = nbPixels;
		this.resolution = resolution;
		this.typeObjectif = typeObjectif;
	}

	// Getter and setter
	public String getTypeObjectif() {
		return typeObjectif;
	}

	public void setTypeObjectif(String typeObjectif) {
		this.typeObjectif = typeObjectif;
	}

	public int getNbMillionsPixels() {
		return nbMillionsPixels;
	}

	public void setNbMillionsPixels(int nbMillionsPixels) {
		this.nbMillionsPixels = nbMillionsPixels;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}
