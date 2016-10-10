package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;

import ComparatorArticle.ComparatorArticlebyMarque;
import ComparatorArticle.ComparatorArticlebyNom;
import ComparatorArticle.ComparatorArticlebyPrix;
import ComparatorArticle.ComparatorArticlebyRef;

public class Magasin {
	private String nom;
	private ArrayList<Client> listeClients;
	private ArrayList<Article> articles;
	private ArrayList<Location> locations;
	private Archivage arch;

	public Magasin(String nom) {
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
		this.articles = new ArrayList<Article>();
		this.locations = new ArrayList<Location>();
		this.arch = new Archivage(this);
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

	public void choixTri (String pref) {
		pref = pref.toLowerCase();
		
		switch (pref) {
		case "nom":
			Collections.sort(this.articles, new ComparatorArticlebyNom());
			break;
		case "marque":
			Collections.sort(this.articles, new ComparatorArticlebyMarque());
			break;
		case "référence":
			Collections.sort(this.articles, new ComparatorArticlebyRef());
			break;
		case "prix":
			Collections.sort(this.articles, new ComparatorArticlebyPrix());
			break;
		default:
			break;
		}
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
		ArrayList<Article> aLouer = (ArrayList<Article>) articles.clone(); 
		for (Article article : aLouer) {
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
	
	public double calculGain(GregorianCalendar gcd, GregorianCalendar gcf){
		double montant = 0.0;
		GregorianCalendar cal = (GregorianCalendar) gcd.clone();
		Calendar
		try {
			ArrayList<Location> locs = this.arch.getLocationsMois(cal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return montant;
	}
}
