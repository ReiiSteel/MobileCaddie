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
	
	public Article(String nom, String reference, String marque, float prixLocationParJour, int nbStock) {
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

	public float getPrixLocationParJour() {
		return prixLocationParJour;
	}

	public int getNbStock() {
		return nbStock;
	}
	
	public boolean louer(){
		if(this.nbStock > 0){ 
			this.nbStock -= 1;
			return true;
		}
		else{
			System.out.println("L'article "+this.marque+" "+this.nom+" "+this.reference+" n'est plus disponible en stock et ne peut être loué.");
			return false;
		}
	}
	
	public String toString(){
		return "Article todo";
	}
}
