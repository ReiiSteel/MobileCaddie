/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class PanneauLED extends AccessoireLumiere{

	private int nombreLED;
	
	/**
	 * Constructeur PanneauLED
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param modele : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 * @param nbLed : nombre de leds du panneau
	 */
	public PanneauLED(String nom, String reference, String modele,
			double prixLocationParJour, int stock, int nbLed) {
		
		super(nom, reference, modele, prixLocationParJour, stock);
		this.nombreLED = nbLed;
	}

	public int getNombreLED() {
		return nombreLED;
	}

	public void setNombreLED(int nombreLED) {
		this.nombreLED = nombreLED;
	}
		
}
