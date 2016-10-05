package main;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Acquisition.Camera;
import Acquisition.Objectif;

public class Main {

	public static void main(String[] args) throws IOException {
		Magasin m1 = new Magasin("yo");
		Client c1 = new Client("Nom", "Nantes");
		Objectif obj = new Objectif("Nom", "ref", "modele", 5, 1, "type obj", 99442, "1920*1080");
		Camera cam = new Camera("Nom", "ref2", "modele", 2.5f, 1, "type obj", 999999, "1920*1080");
		ArrayList<Article> arts = new ArrayList<Article>();
		arts.add(obj);
		arts.add(cam);

		m1.louer(c1, arts, 0, 0, 20);
		try {
			m1.archive();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


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

			// Ref client
			while(c != ';') {				
				String refClient = "";
				c = fluxBinaire.readChar();
				refClient += c;
			}

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

			for (int i = 0; i < nbArticles; i++) {
				System.out.println(refArticleSplit[i]);
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
