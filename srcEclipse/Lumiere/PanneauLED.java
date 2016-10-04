/**
*
*@author Flambard William Martin Johan
*/
package Lumiere;

public class PanneauLED extends AccessoireLumiere{

	private int nombreLED;
	
	public PanneauLED(String nom, String reference, String modele,
			float prixLocationParJour, int nbStock, int nbLed) {
		
		super(nom, reference, modele, prixLocationParJour, nbStock);
		this.nombreLED = nbLed;
	}
	
}
