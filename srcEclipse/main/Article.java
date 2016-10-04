package main;
/**
*
*@author Flambard William Martin Johan
*/
public class Article {
	// Reference unique
	private String reference;
	private String marque;
	private String nom;
	private float prixLocationParJour;
	private int nbStock;
	
	public Article(String nom, String reference, String modele, float prixLocationParJour, int nbStock) {
		// ! Référence unique TODO
		this.nom = nom;
		this.reference = reference;
		this.marque = modele;
		this.prixLocationParJour = prixLocationParJour;
		this.nbStock = nbStock;		
	}

	public String getReference() {
		return reference;
	}

	public String getMarque() {
		return marque;
	}

	public String getNom() {
		return nom;
	}

	public float getPrixLocationParJour() {
		return prixLocationParJour;
	}

	public int getNbStock() {
		return nbStock;
	}
	
}
