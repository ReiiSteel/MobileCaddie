package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Archivage {

	private ArrayList<String> fichier;
	private Magasin m1;

	public Archivage(Magasin m1) {
		this.m1 = m1;
		this.fichier = new ArrayList<String>();
	}

	/**
	 *  Méthode pour archiver les locations
	 * @throws IOException
	 */
	public boolean nouvelleArchive() throws IOException {
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
		ArrayList<Location> locationsSurDateEnCours = m1.getLocationsDateFinMoisAnnee(dateEnCours);
		Iterator<Location> itr = locationsSurDateEnCours.iterator();
		while(itr.hasNext()) {
			Location loc = (Location) itr.next();
			int nbArticles = loc.getArticles().size();
			int refClient = loc.getClient().getRefClient();

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
			fluxSortieBinaire.writeInt(refClient);
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
		System.out.println("Toutes les locations ont été archivées");
		fluxSortieBinaire.close();
		return (this.fichier.add(fichier));
	}

	/**
	 * 
	 * @param Magasin
	 * @param GregorianCalendar
	 * @return ArrayList<Location>
	 * @throws IOException
	 */
	public ArrayList<Location> getLocationsMois(GregorianCalendar cal) throws IOException {
		ArrayList<Location> locationsMois = new ArrayList<Location>();
		
		String fichier = "";
		fichier += cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		fichier += month;
		fichier += ".loc";
		
		if(this.fichier.contains(fichier)) {
			// Ouverture du flux
			DataInputStream fluxBinaire = new DataInputStream(new FileInputStream(fichier));
			try {
				while(true) {
					int nbArticles = fluxBinaire.readInt();
					char c = '\0';

					// Ref client
					int refClient = fluxBinaire.readInt();

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
					Client client = (Client) m1.getClientByRef(Integer.valueOf(refClient));

					// Récupération des articles			
					ArrayList<Article> articleArchive = new ArrayList<Article>();
					for(String ref : refArticleSplit) {
						articleArchive.addAll(m1.getArticleByRef(ref));
					}
					
					// Debug
					/*System.out.println(client);
						System.out.println(articleArchive);
						System.out.println(dayDebut);
						System.out.println(monthDebut);
						System.out.println(yearDebut);
						System.out.println(dayFin);
						System.out.println(monthFin);
						System.out.println(yearFin);*/
					
					Location loc = new Location(client, articleArchive, dayDebut, monthDebut, yearDebut, dayFin, monthFin, yearFin);
					locationsMois.add(loc);
				}
			}
			catch(EOFException e1){
				System.out.println("Toutes les locations ont été désarchivées");
			}
			catch(IOException e2) {
				System.out.println("Erreur d'E/S " + e2.getMessage());
			}

			// Fermeture du flux
			fluxBinaire.close();

			return locationsMois;
		}
		else {
			System.out.println("Archive non trouvée ! " + fichier);
			return null;
		}
	}
}
