package main;
/**
*
*@author Flambard William Martin Johan
*/
import java.util.ArrayList;


public class Client {
	private String nom;
	private String adresse;
	private ArrayList<Location> locations;
	
	public Client (String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
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

	public ArrayList<Location> getLocations() {
		return locations;
	}
	/* GETTER AND SETTER */

	// Ajoute une location au client
	public void ajoutLocation(Location loc) {
		this.locations.add(loc);
	}
	
	
	
}
