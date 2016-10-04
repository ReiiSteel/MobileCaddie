package main;

import java.io.DataInputStream;
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
		
		
		String fichier = "";
		GregorianCalendar dateEnCours = new GregorianCalendar();
		fichier += dateEnCours.get(Calendar.YEAR);
		int month = dateEnCours.get(Calendar.MONTH);
		fichier += month;
		fichier += ".loc";

		// Ouverture du flux
		DataInputStream fluxEntreeBinaire;
		try {
			fluxEntreeBinaire = new DataInputStream(new FileInputStream(fichier));
			
			int nbArticles = fluxEntreeBinaire.readInt();
			char nomClient = fluxEntreeBinaire.readChar();
			System.out.println(nbArticles);
			System.out.println(nomClient);
			fluxEntreeBinaire.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Pas d'archive trouvée !");
		}

		

		// Fermeture du flux
		
	}
}
