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
	
	public Magasin(String nom) {
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
		this.articles = new ArrayList<Article>();
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
	
	// Methode pour récupérer une ArrayList d'Article pour une référence donnée
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
	
	// Methode pour récupérer une ArrayList d'Article pour une marque donnée
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
	
	// Methode pour récupérer une ArrayList d'Article pour un nom (intitulé) donné
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
	
	// Methode pour récupérer une ArrayList d'Article pour un prix de location par jour
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
		return null;
	}
	
	// Méthode pour archiver les locations
	public void archive () throws IOException {
		// Génération du nom du fichier YEARMONTH.loc
		String fichier = "";
		GregorianCalendar dateEnCours = new GregorianCalendar();
		fichier += dateEnCours.get(Calendar.YEAR);
		fichier += dateEnCours.get(Calendar.MONTH);
		fichier += ".loc";

		// Ouverture du flux
		DataOutputStream fluxSortieBinaire = new DataOutputStream(new FileOutputStream(fichier));
		
		// Fermeture du flux
		fluxSortieBinaire.close();
	}
	
}
