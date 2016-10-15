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
/** 
 * Classe représentant le magasin
 *@author Flambard William Martin Johan
 *
 */
public class Magasin {
	private String nom;
	private ArrayList<Client> listeClients;
	private ArrayList<Article> articles;
	private ArrayList<Location> locationsEnCours;
	private Archivage arch;

	/**
	 * Constructeur de magasin
	 * @param nom : nom du magasin
	 */
	public Magasin(String nom) {
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
		this.articles = new ArrayList<Article>();
		this.locationsEnCours = new ArrayList<Location>();
		this.arch = new Archivage();
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
	
	public ArrayList<Location> getLocationEnCours() {
		return this.locationsEnCours;
	}
	/* GETTER AND SETTER */

	/**
	 * Retourne vrai si le client existe
	 * Retourne faux si le client n'existe pas
	 * @param refClient : référence du client
	 * @return boolean
	 */
	public boolean clientExiste(int refClient) {
		boolean existe = false;
		for (Client c : this.listeClients) {
			if(c.getRefClient() == refClient) {
				existe = true;
			}
		}
		return existe;
	}
	
	/**
	 * Ajoute un client au magasin
	 * @param client : client à ajouter
	 */
	public void ajoutClient(Client client) {
		this.listeClients.add(client);
	}
	
	/**
	 * Ajoute un article au magasin
	 * @param art : article à ajouter
	 */
	public void ajoutArticle(Article art) {
		this.articles.add(art);
	}
	
	
	public ArrayList<Location> getLocationsDateFinMoisAnnee (GregorianCalendar cal) {
		ArrayList<Location> locationsReturned = new ArrayList<Location>();
		Iterator<Location> itr = this.locationsEnCours.iterator();
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
	 * @param ref : référence d'un article
	 * @return Une liste d'article ayant la référence ref
	 */
	public ArrayList<Article> getArticleByRef (String ref) {
		ArrayList<Article> articlesByRef = new ArrayList<Article>();
		
		for (Article art : this.articles) {
			if(art.getReference().equals(ref)) {
				articlesByRef.add(art);
			}
		}
		return articlesByRef;
	}

	/**
	 * Tri les locations en cours
	 * @param pref : préférence de l'utilisateur
	 */
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
	 * Loue des articles a un client sur une période
	 * @param client : client de la location
	 * @param articles : articles à louer
	 * @param nbYear : nombre d'années de la location
	 * @param nbMonth : nombre de mois de la location
	 * @param nbDay : nombre de jour de la location
	 * @return
	 */
	public Location locationPeriodique(Client client, ArrayList<Article> articles, int nbYear, int nbMonth, int nbDay){
		ArrayList<Article> aLouer = (ArrayList<Article>) articles.clone(); 
		for (Article article : aLouer) {
			if(!article.estLouable()) {
				articles.remove(article);
			}
		}

		if(articles.size() > 0){
			Location location = new Location(client, articles, nbYear, nbMonth, nbDay);
			client.ajoutLocation(location);
			this.locationsEnCours.add(location);
			return location;
		}
		else{
			System.out.println("Aucun article n'est louable, car non disponible en stock");
			return null;
		}		
	}
	
	/**
	 * Méthode juste pour tester un location déjà terminée ! (cf troisième location dans le main)
	 * Cette méthode ne gère pas le stock par exemple.
	 * @param client : client de la location
	 * @param loc : location
	 */
	public void setLocationsEnCours(Client client, Location loc) {
		this.locationsEnCours.add(loc);
		client.ajoutLocation(loc);
	}
	
	/**
	 * Permet de terminer une location
	 * @param loc : location à terminer
	 * @throws IOException
	 */
	public void locationTerminee (Location loc) throws IOException {
		if(loc.isEnd()) {
			// Archivage de la location
			this.arch.nouvelleArchive(this, loc);
			
			// +1 Stock article
			for (Article art : loc.getArticles()) {
				art.retourLocation(); 
			}
			
			// Supression dans les locations en cours
			this.locationsEnCours.remove(loc);
			
			System.out.println("Location terminée !");
		}
		else {
			System.out.println("Impossible de terminer la location à cause de sa date de fin !");
		}
	}
	
	/**
	 * @param ref : référence d'un client
	 * @return : Retourne un client
	 */
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
	
	/**
	 * Calcul le gain du magasin de la date de début jusqu'à la date de fin
	 * @param gcd : date de début
	 * @param gcf : date de fin
	 * @return montant du gain
	 */
	public double calculGain(GregorianCalendar gcd, GregorianCalendar gcf){
		double montant = 0.0;
		ArrayList<Location> locs = new ArrayList<Location>();
		GregorianCalendar cal = (GregorianCalendar) gcd.clone();
		while(cal.get(Calendar.YEAR) <= gcf.get(Calendar.YEAR)){
			if(cal.get(Calendar.YEAR) >= gcf.get(Calendar.YEAR) && cal.get(Calendar.MONTH) > gcf.get(Calendar.MONTH)){
				break;
			}
			else{
				try {
					locs.addAll(this.arch.getLocationsMois(this ,cal));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NullPointerException e){
				} finally{
					cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
				}
			}
		}
		for (Location location : locs) {
			montant += location.getMontantPeriode(gcd, gcf);
		}
		for (Location location : this.locationsEnCours) {
			/*// Pour gérer le Calendar qui commence les mois à janvier = 0 ...
			GregorianCalendar cal2 = (GregorianCalendar) location.getDateFin().clone();
			GregorianCalendar cal3 = (GregorianCalendar) location.getDateDebut().clone();
			cal2.set(Calendar.MONTH, location.getDateFin().get(Calendar.MONTH) +1);
			cal3.set(Calendar.MONTH, location.getDateDebut().get(Calendar.MONTH) +1);
			*/
			if( (location.getDateFin().compareTo(gcf) == -1 || location.getDateFin().compareTo(gcf) == 0) && (location.getDateDebut().compareTo(gcd) == 0 || location.getDateDebut().compareTo(gcd) == 1) ){
				System.out.println(location);
				montant += location.getMontantPeriode(gcd, gcf);
			}
		}
		return montant;
	}	
	
	/**
	 * Permet de récupérer les locations archivées sur le mois courant
	 * @return liste de locations
	 */
	public ArrayList<Location> getLocationArchiveMoisCourant() {
		GregorianCalendar cal = new GregorianCalendar();
		try {
			return this.arch.getLocationsMois(this, cal);
		} catch (IOException e) {
			e.printStackTrace();
			ArrayList<Location> loc = new ArrayList<Location>();
			return loc;
		}
	}
}
