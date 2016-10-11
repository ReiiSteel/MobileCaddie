package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Acquisition.AppareilPhoto;
import Acquisition.Camera;
import Acquisition.Objectif;
import Lumiere.FondStudio;
import Lumiere.PanneauLED;
import Lumiere.Reflecteur;
import Stabilisation.Grue;
import Stabilisation.Trepied;
import Stabilisation.Ventouse;

public class Main {

	public static void main(String[] args) throws IOException {
		/*Magasin m1 = new Magasin("yo");
		Client c1 = new Client("Nom", "Nantes");
		Client c2 = new Client("Nom2", "Nantes aussi");
		m1.ajoutClient(c1);
		m1.ajoutClient(c2);
		Objectif obj = new Objectif("Nom", "ref", "modele", 5, 40, "type obj", 99442, "1920*1080");
		Camera cam = new Camera("Nom", "ref2", "modele", 2.5f, 40, "type obj", 999999, "1920*1080");
		m1.ajoutArticle(obj);
		m1.ajoutArticle(obj);
		ArrayList<Article> arts = new ArrayList<Article>();
		arts.add(obj);
		arts.add(cam);

		Location loc = m1.locationPeriodique(c1, arts, 0, 0, 20);
		Location loc2 = m1.locationPeriodique(c2, arts, 0, 0, 2);
		
		GregorianCalendar cal = new GregorianCalendar();
		Location l1 = new Location(c1, arts, 1, 1, 2015, 8, 10, 2016);
		//System.out.println(l1);
		c1.ajoutLocation(l1);
		m1.setLocationsEnCours(l1);
		System.out.println(m1.getLocationsDateFinMoisAnnee(cal));
		m1.locationTerminee(l1);
		
		GregorianCalendar gcd = new GregorianCalendar();
		gcd.set(Calendar.YEAR, 2015);
		gcd.set(Calendar.MONTH, 0);
		gcd.set(Calendar.DATE, 1);
		GregorianCalendar gcf = new GregorianCalendar();
		gcf.set(Calendar.YEAR, 2016);
		gcf.set(Calendar.MONTH, 0);
		gcf.set(Calendar.DATE, 1);
		System.out.println(m1.calculGain(gcd, gcf));
		
		//System.out.println(m1.getArchive().getLocationsMois(m1, cal));
		System.out.println(l1.isEnd());
		System.out.println(m1.getArchive().getLocationsMois(m1, cal));*/
		
		/*
		 	Jeu de données
		 */
		Magasin m1 = new Magasin("Odin");
		
		// Clients
		Client c1 = new Client("Sophie", "44300 Nantes");
		Client c2 = new Client("Valentin", "Lyon");
		Client c3 = new Client("Sandrine", "44000 Nantes");
		Client c4 = new Client("Cédric", "Orvault");
		Client c5 = new Client("Quentin", "44600 Saint-Nazaire");
		Client c6 = new Client("Léa", "Paris");
		// On ajoute les clients au magasin
		m1.ajoutClient(c1);
		m1.ajoutClient(c2);
		m1.ajoutClient(c3);
		m1.ajoutClient(c4);
		m1.ajoutClient(c5);
		m1.ajoutClient(c6);
		
		// Articles
		AppareilPhoto appareilPhoto = new AppareilPhoto("Appareil photo", "4A", "Canon", 50f, 4, "????",4000000, "12k");
		Camera camera = new Camera("Camera", "1I", "Sony", 2f, 50, "????", 5, "120*80");
		Objectif objectif = new Objectif("Objectif", "PA", "Atol", 5f, 10, "????", 20, "1080*800");
		FondStudio fondStudio = new FondStudio("Fond studio", "OP", "Colorama", 10f, 2, 2.5f, "bleu");
		PanneauLED panneauLed = new PanneauLED("Panneau LED", "LF", "Lastolite", 15f, 1, 40);
		Reflecteur reflecteur = new Reflecteur("Reflecteur", "OP1", "Colorama", 12f, 2, 3f);
		Grue grue = new Grue("Grue", "FK", "Noname", 4000f, 1, 10f);
		Trepied trepied = new Trepied("Trepied", "12", "Canon", 3f, 5, 5);
		Ventouse ventouse = new Ventouse("Ventouse", "FF", "Nicon", 0.2f, 26, 55f);
		// On ajoute les articles au magasin
		m1.ajoutArticle(appareilPhoto);
		m1.ajoutArticle(camera);
		m1.ajoutArticle(objectif);
		m1.ajoutArticle(fondStudio);
		m1.ajoutArticle(panneauLed);
		m1.ajoutArticle(reflecteur);
		m1.ajoutArticle(grue);
		m1.ajoutArticle(trepied);
		m1.ajoutArticle(ventouse);
		
		// Création des locations
		ArrayList<Article> lotArticle1 = new ArrayList<Article>();
		lotArticle1.add(appareilPhoto);
		lotArticle1.add(objectif);
		m1.locationPeriodique(c1, lotArticle1, 0, 0, 20);
		
		ArrayList<Article> lotArticle2 = new ArrayList<Article>();
		lotArticle2.add(panneauLed);
		lotArticle2.add(objectif);
		m1.locationPeriodique(c2, lotArticle2, 0, 2, 0);
		
		GregorianCalendar gcd = new GregorianCalendar();
		gcd.set(Calendar.YEAR, 2015);
		GregorianCalendar gcf = new GregorianCalendar();
		gcd.set(Calendar.YEAR, 2017);
		
		System.out.println(m1.calculGain(gcd, gcf));
		/*
	 		Jeu de données
		 */
		
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int option;
			
			// Display menu graphics
			System.out.println("====================================");
			System.out.println("|   MENU SELECTION DEMO            |");
			System.out.println("====================================");
			System.out.println("| Options:                         |");
			System.out.println("|        1. Afficher les locations |");
			System.out.println("|        2. Afficher les clients   |");
			System.out.println("|        4. Afficher les articles  |");
			System.out.println("|        5. Ajouter un article     |");
			System.out.println("|        6. Ajouter un client      |");
			System.out.println("|        7. Ajouter une location   |");
			System.out.println("|        8. Quitter                |");
			System.out.println("====================================");	
			
			option = Integer.valueOf(br.readLine());
			
			if(option == 1) {
				
			}
			else if (option == 2) {
				
			}
			else if (option == 3) {

			}
			else if (option == 4) {

			}
			else if (option == 5) {

			}
			else if (option == 6) {
				System.out.println("Le programme va se fermer...");
				System.exit(0);
			}
			else {
				
			}
		}
	}
}
