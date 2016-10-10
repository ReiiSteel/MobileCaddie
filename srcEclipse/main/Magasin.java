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

	/**
	 *  Methode pour récupérer une ArrayList d'Article pour une référence donnée
	 * @param reference
	 * @return liste des articles
	 */
	public ArrayList<Article> getArticlesLouesByRef(String reference) {
		Iterator<Article> itr = articles.iterator();
		ArrayList<Article> artReturned = new ArrayList<Article>();
		while(itr.hasNext()) {
			Article art = (Article) itr.next();
			if(art.getReference().equals(reference)) {
				artReturned.add(art);
			}	    	
		}
		return artReturned;
	}

	/**
	 *  Methode pour récupérer une ArrayList d'Article pour une marque donnée
	 * @param marque
	 * @return liste des articles
	 */
	public ArrayList<Article> getArticlesLouesByMarque(String marque) {
		Iterator itr = articles.iterator();
		ArrayList<Article> artReturned = new ArrayList<Article>();
		while(itr.hasNext()) {
			Article art = (Article) itr.next();
			if(art.getMarque() == marque) {
				artReturned.add(art);
			}	    	
		}
		return artReturned;
	}

	/**
	 *  Methode pour récupérer une ArrayList d'Article pour un nom (intitulé) donné
	 * @param nom
	 * @return liste des articles
	 */
	public ArrayList<Article> getArticlesLouesByNom(String nom) {
		Iterator itr = articles.iterator();
		ArrayList<Article> artReturned = new ArrayList<Article>();
		while(itr.hasNext()) {
			Article art = (Article) itr.next();
			if(art.getNom() == nom) {
				artReturned.add(art);
			}	    	
		}
		return artReturned;
	}

	/**
	 *  Methode pour récupérer une ArrayList d'Article pour un prix de location par jour
	 * @param prixParJour
	 * @return liste des articles
	 */
	public ArrayList<Article> getArticlesLouesByPrix(float prixParJour) {
		Iterator itr = articles.iterator();
		ArrayList<Article> artReturned = new ArrayList<Article>();
		while(itr.hasNext()) {
			Article art = (Article) itr.next();
			if(art.getPrixLocationParJour() == prixParJour) {
				artReturned.add(art);
			}	    	
		}
		return artReturned;
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
