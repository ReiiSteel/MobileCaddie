package main;
/**
* Classe représentant un client
*@author Flambard William Martin Johan
*/
import java.util.ArrayList;


public class Client {
	private String nom;
	private String adresse;
	private static int nbrefClient;
	private int refClient;
	private ArrayList<Location> locations;
	
	/**
	 * Constructeur de Client
	 * @param nom : nom du client
	 * @param adresse : adresse du client
	 */
	public Client (String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
		this.locations = new ArrayList<Location>();
		Client.nbrefClient ++;
		this.refClient = nbrefClient;
	}

	/* GETTER AND SETTER */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getRefClient() {
		return refClient;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}
	/* GETTER AND SETTER */

	/**
	 * Attribution d'une location à un client
	 * @param loc : location à ajouter
	 */
	public void ajoutLocation(Location loc) {
		this.locations.add(loc);
	}
	
	/**
	 * To String
	 */
	public String toString () {
		return("nom : " + this.getNom() + " adresse : " + this.getAdresse() + " avec la référence : " + this.getRefClient());
		
	}
	
	
}
