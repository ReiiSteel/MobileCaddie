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

	public Location louer(Client client, ArrayList<Article> articles, int year, int month, int day){
		// TODO nbStock article à gérer
		Location location = new Location(client, articles, year, month, day);
		client.ajoutLocation(location);
		this.locations.add(location);

		return null;
	}
	
	public Client getClientByRef(String ref) {
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
		ArrayList<Location> locationsSurDateEnCours = this.getLocationsDateFinMoisAnnee(dateEnCours);
		Iterator<Location> itr = locationsSurDateEnCours.iterator();
		while(itr.hasNext()) {
			Location loc = (Location) itr.next();
			int nbArticles = loc.getArticles().size();
			String refClient = loc.getClient().getRefClient();

			// Récupération de la date de début
			int yearDebut = loc.getDateDebut().get(Calendar.YEAR);
			int monthDebut = loc.getDateDebut().get(Calendar.MONTH);
			int dayDebut = loc.getDateDebut().get(Calendar.DATE);

			// Récupération de la date de fin
			int yearFin = loc.getDateFin().get(Calendar.YEAR);
			int monthFin = loc.getDateFin().get(Calendar.MONTH);
			int dayFin = loc.getDateFin().get(Calendar.DATE);

			/*
				Ecriture au format : 
					nombre d'articles loués 
					ref client
					jour mois année de la date de début de location
					jour mois année de la date de fin de locatin
					ref article
					ref article
					...
			 */
			fluxSortieBinaire.writeInt(nbArticles);
			fluxSortieBinaire.writeChars(refClient + ";");
			fluxSortieBinaire.writeInt(dayDebut);
			fluxSortieBinaire.writeInt(monthDebut);
			fluxSortieBinaire.writeInt(yearDebut);
			fluxSortieBinaire.writeInt(dayFin);
			fluxSortieBinaire.writeInt(monthFin);
			fluxSortieBinaire.writeInt(yearFin);			

			ArrayList<Article> articles = loc.getArticles();
			for (Article article : articles) {
				fluxSortieBinaire.writeChars(article.getReference() + ";");
			}
			
			fluxSortieBinaire.writeChar('\\');
		}

		// Fermeture du flux
		fluxSortieBinaire.close();
	}

	/**
	 *  Méthode pour remettre en mémoire toutes les locations en cours
	 * @throws IOException
	 */
	public void memLocEnCours () throws IOException {
		// Peut être un simple print 
		
		// Génération du nom du fichier YEARMONTH.loc
		String fichier = "";
		GregorianCalendar dateEnCours = new GregorianCalendar();
		fichier += dateEnCours.get(Calendar.YEAR);
		int month = dateEnCours.get(Calendar.MONTH);
		fichier += month;
		fichier += ".loc";

		// Ouverture du flux
		DataInputStream fluxBinaire = new DataInputStream(new FileInputStream(fichier));
		try {
			int nbArticles = fluxBinaire.readInt();
			char c = '\0';
			
			String refClient = "";
			// Ref client
			while(c != ';') {			
				c = fluxBinaire.readChar();
				refClient += c;
			}
			refClient = refClient.substring(0, refClient.length()-1);
			
			// Dates
			int dayDebut = fluxBinaire.readInt();
			int monthDebut = fluxBinaire.readInt();
			int yearDebut = fluxBinaire.readInt();
			int dayFin = fluxBinaire.readInt();
			int monthFin = fluxBinaire.readInt();
			int yearFin = fluxBinaire.readInt();		
			
			c = '\0';

			String refArticle = "";
			for (int i = 0; i < nbArticles; i++) {
				while(c != '\\') {
					c = fluxBinaire.readChar();
					refArticle += c;
				}
			}
			
			String[] refArticleSplit = refArticle.split(";");
			
			// Récupération du client
			Client client = (Client) this.getClientByRef(refClient);
			
			// Récupération de l'article			
			ArrayList<Article> articleArchive = new ArrayList<Article>();
			for(String ref : refArticleSplit) {
				articleArchive.addAll(this.getArticlesLouesByRef(ref));
			}

			for (int i = 0; i < nbArticles; i++) {
				
				Location loc = new Location(client, articleArchive, dayDebut, monthDebut, yearDebut, dayFin, monthFin, yearFin);
				System.out.println(loc);
			}
		}
		catch(EOFException e1){
			System.out.println("Terminaison normale : tous les fichiers ont été lus");
		}
		catch(IOException e2) {
			System.out.println("Erreur d'E/S " + e2.getMessage());
		}

		// Fermeture du flux
		fluxBinaire.close();
	}

}
