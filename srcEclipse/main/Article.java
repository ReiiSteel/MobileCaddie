package main;
/**
* Classe représentant de façon abstraite un article
*@author Flambard William Martin Johan
*/
public abstract class Article {
	// Reference unique
	private String reference;
	private String marque;
	private String nom;
	private double prixLocationParJour;
	private int nbStock;
	
	/**
	 * Constructeur Article
	 * @param nom : nom de l'article
	 * @param reference : référence de l'article
	 * @param marque : marque de l'article
	 * @param prixLocationParJour : prix par jour de location
	 * @param stock : nombre d'article
	 */
	public Article(String nom, String reference, String marque, double prixLocationParJour, int nbStock) {
		this.nom = nom;
		this.reference = reference;
		this.marque = marque;
		this.prixLocationParJour = prixLocationParJour;
		this.nbStock = nbStock;	
	}
	
	// Getter and setter
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
	
	/**
	 * Vrai si l'article est louable (disponible au niveau des stocks)
	 * Faux si non
	 * @return boolean
	 */
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
	
	/**
	 * Gère le retour d'une location
	 */
	public void retourLocation() {
		this.nbStock =+ 1;
	}
	
	/**
	 * To string
	 */
	public String toString(){
		return ("L'article " + this.getNom() + " de la marque " + this.getMarque() + " avec la référence " + this.getReference() +
				" a un prix de location par jour de " + this.getPrixLocationParJour() + "€ Il en reste " + this.getNbStock() + " dans le magasin ! \n");
	}
}
