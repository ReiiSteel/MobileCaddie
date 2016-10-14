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
import Son.Micro;
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
		
		// Jeu de données
		Magasin m1 = creationJeuDeDonnees();
		
		boolean breakMain = true;
		boolean breakMain2 = true;
		
		while(breakMain) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int option;
			
			// Display menu graphics
			menuPrincipal();
			
			try{
				option = Integer.valueOf(br.readLine());
			}
			catch(NumberFormatException ne){
				System.out.println("Veuillez entrer une option correcte.");
				option = 0;
			}
			
			if(option == 1) {
				System.out.println("\n==================================================================================");
				System.out.println("|   Locations en cours                                                           |");
				System.out.println("==================================================================================");
				for (Location loc : m1.getLocationEnCours()) {
					System.out.println(loc);
				}
			}
			else if (option == 2) {
				System.out.println("\n==================================================================================");
				System.out.println("|   Clients du magasin                                                           |");
				System.out.println("==================================================================================");
				for (Client c : m1.getListeClients()) {
					System.out.println(c);
				}
			}
			else if (option == 3) {
				System.out.println("\n==================================================================================");
				System.out.println("|   Liste des articles du magasin                                                 |");
				System.out.println("==================================================================================");
				for (Article a : m1.getArticles()) {
					System.out.println(a);
				}
			}
			else if (option == 4) {
				while(breakMain2) {
					// Menu pour choisir un article à ajouter
						menuAjoutArticle();						
					try {
						option = Integer.valueOf(br.readLine());
					}
					catch(NumberFormatException ne){
						System.out.println("Veuillez entrer une option correcte.");
						option = 0;
					}
					if (option == 1) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String stringAppareilPhoto = br.readLine();
						creationAppareilPhoto(stringAppareilPhoto, m1);	
					}
					else if (option == 2) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String stringCamera = br.readLine();
						creationCamera(stringCamera, m1);						
					}					
					else if (option == 3) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String stringObjectif = br.readLine();
						creationObjectif(stringObjectif, m1);
					}
					else if (option == 4) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nla taille"
								+ " et la couleur. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String fondDeStudio = br.readLine();
						creationFondDeStudio(fondDeStudio, m1);
					}
					else if (option == 5) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\n"
								+ "et le nombre de leds. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String panneauLed = br.readLine();
						creationPanneauLed(panneauLed, m1);
					}
					else if (option == 6) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\n"
								+ "et la taille du reflecteur. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String reflecteur = br.readLine();
						creationReflecteur(reflecteur, m1);					
					}
										
					else if (option == 7) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour et le nombre?"
								+ "\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String micro = br.readLine();
						creationMicro(micro, m1);		
					}
					else if (option == 8) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et la hauteur du trepied.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String trepied = br.readLine();
						creationTrepied(trepied, m1);		
					}
					else if (option == 9) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et la longueur de la grue.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String grue = br.readLine();
						creationGrue(grue, m1);		
					}
					else if (option == 10) {
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et le diamètre de la ventouse.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par un espace !");
						String ventouse = br.readLine();
						creationVentouse(ventouse, m1);		
					}	
					else if (option == 11) {
						// Retour au menu principal
						breakMain2 = false;
					}
					else {
						System.out.println("Veuillez entrer une option correcte.");
					}
				}
			}
			else if (option == 5) {
				while(breakMain2) {
					System.out.println("\n==================================================================================");
					System.out.println("|   Nouveau client                                                               |");
					System.out.println("==================================================================================");
					System.out.println("Nom :");					


					try {
						option = Integer.valueOf(br.readLine());
					}
					catch(NumberFormatException ne){
						System.out.println("Veuillez entrer une option correcte.");
						option = 0;
					}
					if (option == 11) {
						breakMain2 = false;
					}
				}
				
			}
			else if (option == 6) {

			}
			else if (option == 7) {
				System.out.println("Le programme va se fermer...");
				breakMain = false;
				System.exit(0);
			}
			else {
				
			}
		}
	}
	
	public static Magasin creationJeuDeDonnees () {
		// TODO création locations archivées
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
		AppareilPhoto appareilPhoto = new AppareilPhoto("Appareil photo", "4A", "Canon", 50, 4, "????",4000000, "12k");
		Camera camera = new Camera("Camera", "1I", "Sony", 2, 50, "????", 5, "120*80");
		Objectif objectif = new Objectif("Objectif", "PA", "Atol", 5, 10, "????", 20, "1080*800");
		FondStudio fondStudio = new FondStudio("Fond studio", "OP", "Colorama", 10, 2, 2.5f, "bleu");
		PanneauLED panneauLed = new PanneauLED("Panneau LED", "LF", "Lastolite", 15, 1, 40);
		Reflecteur reflecteur = new Reflecteur("Reflecteur", "OP1", "Colorama", 12, 2, 3);
		Grue grue = new Grue("Grue", "FK", "Noname", 4000, 1, 10);
		Trepied trepied = new Trepied("Trepied", "12", "Canon", 3, 5, 5);
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
		gcd.set(Calendar.MONTH, 0);
		gcd.set(Calendar.DATE, 1);
		GregorianCalendar gcf = new GregorianCalendar();
		gcf.set(Calendar.YEAR, 2017);
		gcf.set(Calendar.MONTH, 0);
		gcf.set(Calendar.DATE, 1);
		
		return m1;
	}
	
	public static void creationCamera(String stringCamera, Magasin m1) {
		String params[] = stringCamera.split(" ");
		Camera cam = new Camera(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), params[5], Integer.valueOf(params[6]), params[7]);
		m1.ajoutArticle(cam);
		System.out.println(cam);
	}
	
	public static void creationAppareilPhoto(String stringAppareilPhoto, Magasin m1) {
		String params[] = stringAppareilPhoto.split(" ");
		Camera app = new Camera(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), params[5], Integer.valueOf(params[6]), params[7]);
		m1.ajoutArticle(app);
	}
	
	public static void creationObjectif(String stringObjectif, Magasin m1) {
		String params[] = stringObjectif.split(" ");
		Objectif obj = new Objectif(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), params[5], Integer.valueOf(params[6]), params[7]);
		m1.ajoutArticle(obj);
	}
	
	public static void creationFondDeStudio(String stringFondDeStudio, Magasin m1) {
		String params[] = stringFondDeStudio.split(" ");
		FondStudio fs = new FondStudio(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Float.parseFloat(params[5]), params[6]);
		m1.ajoutArticle(fs);
	}
	
	public static void creationPanneauLed(String stringPanneauLed, Magasin m1) {
		String params[] = stringPanneauLed.split(" ");
		PanneauLED panneauLed = new PanneauLED(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Integer.valueOf(params[4]));
		m1.ajoutArticle(panneauLed);
	}
	
	public static void creationReflecteur(String stringReflecteur, Magasin m1) {
		String params[] = stringReflecteur.split(" ");
		Reflecteur ref = new Reflecteur(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(ref);
	}
	
	public static void creationMicro(String stringMicro, Magasin m1) {
		String params[] = stringMicro.split(" ");
		Micro mic = new Micro(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]));
		m1.ajoutArticle(mic);
	}

	public static void creationTrepied(String stringTrepied, Magasin m1) {
		String params[] = stringTrepied.split(" ");
		Trepied trepied = new Trepied(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Integer.valueOf(params[4]));
		m1.ajoutArticle(trepied);
	}
	
	public static void creationGrue(String stringGrue, Magasin m1) {
		String params[] = stringGrue.split(" ");
		Grue grue = new Grue(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(grue);
	}
	
	public static void creationVentouse(String stringVentouse, Magasin m1) {
		String params[] = stringVentouse.split(" ");
		Ventouse ventouse = new Ventouse(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(ventouse);
	}
	
	public static void menuPrincipal() {
		System.out.println("\n==================================================================================");
		System.out.println("|   MENU TOOl                                                                    |");
		System.out.println("==================================================================================");
		System.out.println("| Options:                                                                       |");
		System.out.println("|        1. Afficher les locations en cours                                      |");
		System.out.println("|        2. Afficher les clients                                                 |");
		System.out.println("|        3. Afficher les articles                                                |");
		System.out.println("|        4. Ajouter un article                                                   |");
		System.out.println("|        5. Ajouter un client                                                    |");
		System.out.println("|        6. Ajouter une location                                                 |");
		System.out.println("|        7. Quitter                                                              |");
		System.out.println("==================================================================================");	
	}
	
	public static void menuAjoutArticle() {
		System.out.println("\n==================================================================================");
		System.out.println("|   Ajout d'un article                                                           |");
		System.out.println("==================================================================================");
		System.out.println("|	Quel article voulez vous ajouter au magasin ?                                |");
		System.out.println("|        1. Un appareil photo                                                    |");
		System.out.println("|        2. Une caméra                                                           |");
		System.out.println("|        3. Un objectif                                                          |");
		System.out.println("|        4. Un fond de studio                                                    |");
		System.out.println("|        5. Un panneau LED                                                       |");
		System.out.println("|        6. Un reflecteur                                                        |");
		System.out.println("|        7. Un micro                                                             |");
		System.out.println("|        8. Un trepied                                                           |");
		System.out.println("|        9. Une grue                                                             |");
		System.out.println("|        10. Une ventouse                                                        |");
		System.out.println("|        11. Retour                                                              |");
		System.out.println("==================================================================================");
	}
}
