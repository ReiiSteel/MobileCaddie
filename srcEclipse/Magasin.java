import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

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
	
	/**
	 *  Methode pour récupérer une ArrayList d'Article pour une référence donnée
	 * @param reference
	 * @return liste des articles
	 */
	public ArrayList<Article> getArticlesLouesByRef(String reference) {
	    Iterator itr = articles.iterator();
	    ArrayList<Article> artReturned = new ArrayList<Article>();
	    while(itr.hasNext()) {
	    	Article art = (Article) itr.next();
	    	if(art.getReference() == reference) {
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
	
	public Location louer(Client client, ArrayList<Article> articles){
		//Location location = new Location();
		//client.ajoutLocation(location);
		//this.locations.add(location);
		return null;
	}
	
	/**
	 *  Méthode pour archiver les locations
	 * @throws IOException
	 */
	public void archive () throws IOException {
		// Génération du nom du fichier YEARMONTH.loc
		String fichier = "";
		GregorianCalendar dateEnCours = new GregorianCalendar();
		fichier += dateEnCours.get(Calendar.YEAR);
		int month = dateEnCours.get(Calendar.MONTH);
		fichier += month;
		fichier += ".loc";

		// Ouverture du flux
		DataOutputStream fluxSortieBinaire = new DataOutputStream(new FileOutputStream(fichier));
		
		// Parcours des locations
		Iterator<Location> itr = this.locations.iterator();
		while(itr.hasNext()) {
			Location loc = (Location) itr.next();
			// Location WIIWIWIWIWIWI
			if (true) {
				
			}
		}
		
		
		// Fermeture du flux
		fluxSortieBinaire.close();
	}
	
	// Méthode pour remettre en mémoire toutes les locations en cours
	
	
	
}
