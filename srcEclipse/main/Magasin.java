package main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import Acquisition.Objectif;

public class Magasin {
	private String nom;
	private ArrayList<Client> listeClients;
	private ArrayList<Article> articles;
	private ArrayList<Location> locations;

	public Magasin(String nom) {
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
		this.articles = new ArrayList<Article>();
		this.locations = new ArrayList<Location>();
	}

	/* GETTER AND SETTER */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	/* GETTER AND SETTER */

	public void ajoutClient(Client client) {
		this.listeClients.add(client);
	}
	
	public void ajoutArticle(Article art) {
		this.articles.add(art);
	}
	
	public ArrayList<Location> getLocationsDateFinMoisAnnee (GregorianCalendar cal) {
		ArrayList<Location> locationsReturned = new ArrayList<Location>();
		Iterator itr = this.locations.iterator();
		while(itr.hasNext()) {
			Location loc = (Location) itr.next();
			if((loc.getDateFin().get(Calendar.YEAR) == cal.get(Calendar.YEAR)) 
					&& (loc.getDateFin().get(Calendar.MONTH) == cal.get(Calendar.MONTH))) {
				locationsReturned.add(loc);
			}			
		}		
		return locationsReturned;
	}
	
	public ArrayList<Article> getArticleByRef (String ref) {
		ArrayList<Article> articlesByRef = new ArrayList<Article>();
		
		for (Article art : this.articles) {
			if(art.getReference().equals(ref)) {
				articlesByRef.add(art);
			}
		}
		return articlesByRef;
	}

	public ArrayList<Location> choixTri (String pref) {
		ArrayList<Location> locationsTriees = new ArrayList<Location>();
		pref = pref.toLowerCase();
// .sort
		switch (pref) {
		case "nom":
			break;
		case "marque":
			break;

		case "référence":
			break;
		case "prix":
			break;

		default:
			break;
		}
		return null;
	}

	/**
	 * Loue des articles a un client
	 * @param client
	 * @param articles
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public Location louer(Client client, ArrayList<Article> articles, int year, int month, int day){
		ArrayList<Article> nonLoue = (ArrayList<Article>) articles.clone(); 
		for (Article article : nonLoue) {
			if (!article.louer()){
				articles.remove(article);
			}
		}
		if(articles.size() > 0){
			Location location = new Location(client, articles, year, month, day);
			client.ajoutLocation(location);
			this.locations.add(location);
			return location;
		}
		else{
			System.out.println("Aucun article n'est louable, car non disponible en stock");
			return null;
		}
		
	}
	
	public Client getClientByRef(int ref) {
		Iterator<Client> itr = listeClients.iterator();
		while(itr.hasNext()) {
			Client clientRecherche = (Client) itr.next();			
			if (clientRecherche.getRefClient() == ref) {
				return clientRecherche;
			}
		}
		Client c = new Client("NULL", "NULL");
		return c;
	}
}
