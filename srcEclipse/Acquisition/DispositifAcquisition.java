/**
*
*@author Flambard William Martin Johan
*/
package Acquisition;
public abstract class DispositifAcquisition {
	
	private String typeObjectif;
	private int nbMillionsPixels;
	private String resolution;
	private Objectif objectif;
	
	public DispositifAcquisition(String typeObjectif, int nbPixels, String resolution, Objectif objectif) {
		this.typeObjectif = typeObjectif;
		this.nbMillionsPixels = nbPixels;
		this.resolution = resolution;
		this.objectif = objectif;
	}

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

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}
	
	
}
