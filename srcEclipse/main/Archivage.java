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

/**
 * 
 *@author Flambard William Martin Johan
 *
 */
public class Archivage {

	private ArrayList<String> fichier;

	public Archivage() {
		this.fichier = new ArrayList<String>();
	}

	/**
	 * Méthode pour archiver les locations
	 * @param m1 : magasin associé à l'archive
	 * @param loc : location à archiver
	 * @return : vrai si la location a été archivée
	 * @throws IOException
	 */
	public boolean nouvelleArchive(Magasin m1, Location loc) throws IOException {
		// Génération du nom du fichier YEARMONTH.loc
		String fichier = "";
		GregorianCalendar dateEnCours = new GregorianCalendar();
		fichier += dateEnCours.get(Calendar.YEAR);
		int month = dateEnCours.get(Calendar.MONTH) + 1;
		fichier += month;
		fichier += ".loc";

		// Ouverture du flux
		DataOutputStream fluxSortieBinaire = new DataOutputStream(new FileOutputStream(fichier, true));


		int nbArticles = loc.getArticles().size();
		int refClient = loc.getClient().getRefClient();

		// Récupération de la date de début
		int yearDebut = loc.getDateDebut().get(Calendar.YEAR);
		int monthDebut = loc.getDateDebut().get(Calendar.MONTH) + 1;
		int dayDebut = loc.getDateDebut().get(Calendar.DATE);

		// Récupération de la date de fin
		int yearFin = loc.getDateFin().get(Calendar.YEAR);
		int monthFin = loc.getDateFin().get(Calendar.MONTH) + 1;
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
		// Articles
		ArrayList<Article> articles = loc.getArticles();
		for (Article article : articles) {
			fluxSortieBinaire.writeChars(article.getReference() + ";");
		}
		// Fin de la location
		fluxSortieBinaire.writeChar('\\');


		// Fermeture du flux
		System.out.println("Toutes les locations ont été archivées");
		fluxSortieBinaire.close();
		return (this.fichier.add(fichier));
	}

	/**
	 * Méthode pour récupérer une archive à partir d'un mois
	 * @param Magasin : magasin lié à l'archive
	 * @param GregorianCalendar : mois de l'archive
	 * @return ArrayList<Location> : liste de locations désarchivées
	 * @throws IOException
	 */
	public ArrayList<Location> getLocationsMois(Magasin m1, GregorianCalendar cal) throws IOException {
		ArrayList<Location> locationsMois = new ArrayList<Location>();
		// Génération du nom du fichier YEARMONTH.loc
		String fichier = "";
		fichier += cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		fichier += month;
		fichier += ".loc";

		// Verification de la présence de l'archive
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

					// Récupération des articles
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
					Location loc = new Location(client, articleArchive, dayDebut, monthDebut-1, yearDebut, dayFin, monthFin-1, yearFin);
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
			ArrayList<Location> loc = new ArrayList<Location>();
			return loc;
		}
	}
}
