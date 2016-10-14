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
	private double prixLocationParJour;
	private int nbStock;
	
	public Article(String nom, String reference, String marque, double prixLocationParJour, int nbStock) {
		this.nom = nom;
		this.reference = reference;
		this.marque = marque;
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

	public double getPrixLocationParJour() {
		return prixLocationParJour;
	}

	public int getNbStock() {
		return nbStock;
	}
	
	public boolean estLouable(){
		if(this.nbStock > 0){ 
			this.nbStock -= 1;
			return true;
		}
		else{
			System.out.println("L'article "+this.marque+" "+this.nom+" "+this.reference+" n'est plus disponible en stock et ne peut être loué.");
			return false;
		}
	}
	
	public void retourLocation() {
		this.nbStock =+ 1;
	}
	
	public String toString(){
		return ("L'article " + this.getNom() + " de la marque " + this.getMarque() + " avec la référence " + this.getReference() +
				" a un prix de location par jour de " + this.getPrixLocationParJour() + "€\n");
	}
}
