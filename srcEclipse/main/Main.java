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
		// Jeu de données
		Magasin m1 = creationJeuDeDonnees();
		
		boolean breakMain = true;
		
		while(breakMain) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int option = 0;
			
			// Affiche menu graphics
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
				boolean breakMain2 = true;
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
						// Appareil photo
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String stringAppareilPhoto = br.readLine();
						creationAppareilPhoto(stringAppareilPhoto, m1);	
					}
					else if (option == 2) {
						// Caméra
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String stringCamera = br.readLine();
						creationCamera(stringCamera, m1);						
					}					
					else if (option == 3) {
						// Objectif
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nle type d'objectif"
								+ ", le nombre de pixels et enfin la résolution. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String stringObjectif = br.readLine();
						creationObjectif(stringObjectif, m1);
					}
					else if (option == 4) {
						// Fond de studio
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\nla taille"
								+ " et la couleur. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String fondDeStudio = br.readLine();
						creationFondDeStudio(fondDeStudio, m1);
					}
					else if (option == 5) {
						// Panneau LED
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\n"
								+ "et le nombre de leds. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String panneauLed = br.readLine();
						creationPanneauLed(panneauLed, m1);
					}
					else if (option == 6) {
						// Reflecteur
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?,\n"
								+ "et la taille du reflecteur. \nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String reflecteur = br.readLine();
						creationReflecteur(reflecteur, m1);					
					}
										
					else if (option == 7) {
						// Micro
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour et le nombre?"
								+ "\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String micro = br.readLine();
						creationMicro(micro, m1);		
					}
					else if (option == 8) {
						// Trepied
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et la hauteur du trepied.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String trepied = br.readLine();
						creationTrepied(trepied, m1);		
					}
					else if (option == 9) {
						// Grue
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et la longueur de la grue.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
						String grue = br.readLine();
						creationGrue(grue, m1);		
					}
					else if (option == 10) {
						// Ventouse
						System.out.println("Saisissez le nom, la référence, le modèle, le prix de location par jour, le nombre?"
								+ " et le diamètre de la ventouse.\nPour rappel, il faut saisir toutes les options en \nles séparants"
								+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
								+ "Exemple : expression avec espace,expression,expression avec espace");
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
				creationNouveauClient(m1);				
			}
			else if (option == 6) {
				creationLocation(m1);
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
		Client c7 = new Client("Sneaky", "92 boulevard des belges, Nantes");
		
		// On ajoute les clients au magasin
		m1.ajoutClient(c1);
		m1.ajoutClient(c2);
		m1.ajoutClient(c3);
		m1.ajoutClient(c4);
		m1.ajoutClient(c5);
		m1.ajoutClient(c6);
		m1.ajoutClient(c7);
		
		// Articles
		AppareilPhoto appareilPhoto = new AppareilPhoto("Appareil photo", "4A", "Canon", 50, 4, "objectif a2",4000000, "12k");
		Camera camera = new Camera("Camera", "1I", "Sony", 2, 50, "objectif a1", 5, "120*80");
		Objectif objectif = new Objectif("Objectif", "PA", "Atol", 5, 10);
		FondStudio fondStudio = new FondStudio("Fond studio", "OP", "Colorama", 10, 2, 2.5, "bleu");
		PanneauLED panneauLed = new PanneauLED("Panneau LED", "LF", "Lastolite", 15, 1, 40);
		Reflecteur reflecteur = new Reflecteur("Reflecteur", "OP1", "Colorama", 12, 2, 3);
		Grue grue = new Grue("Grue", "FK", "Noname", 4000, 1, 10);
		Trepied trepied = new Trepied("Trepied", "12", "Canon", 3, 5, 5);
		Ventouse ventouse = new Ventouse("Ventouse", "FF", "Nicon", 0.2, 26, 55);
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
		String params[] = stringCamera.split(",");
		Camera cam = new Camera(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), params[5], Integer.valueOf(params[6]), params[7]);
		m1.ajoutArticle(cam);
		System.out.println(cam);
	}
	
	public static void creationAppareilPhoto(String stringAppareilPhoto, Magasin m1) {
		String params[] = stringAppareilPhoto.split(",");
		Camera app = new Camera(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), params[5], Integer.valueOf(params[6]), params[7]);
		m1.ajoutArticle(app);
	}
	
	public static void creationObjectif(String stringObjectif, Magasin m1) {
		String params[] = stringObjectif.split(",");
		Objectif obj = new Objectif(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]));
		m1.ajoutArticle(obj);
	}
	
	public static void creationFondDeStudio(String stringFondDeStudio, Magasin m1) {
		String params[] = stringFondDeStudio.split(",");
		FondStudio fs = new FondStudio(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Float.parseFloat(params[5]), params[6]);
		m1.ajoutArticle(fs);
	}
	
	public static void creationPanneauLed(String stringPanneauLed, Magasin m1) {
		String params[] = stringPanneauLed.split(",");
		PanneauLED panneauLed = new PanneauLED(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Integer.valueOf(params[4]));
		m1.ajoutArticle(panneauLed);
	}
	
	public static void creationReflecteur(String stringReflecteur, Magasin m1) {
		String params[] = stringReflecteur.split(",");
		Reflecteur ref = new Reflecteur(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(ref);
	}
	
	public static void creationMicro(String stringMicro, Magasin m1) {
		String params[] = stringMicro.split(",");
		Micro mic = new Micro(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]));
		m1.ajoutArticle(mic);
	}

	public static void creationTrepied(String stringTrepied, Magasin m1) {
		String params[] = stringTrepied.split(",");
		Trepied trepied = new Trepied(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Integer.valueOf(params[4]));
		m1.ajoutArticle(trepied);
	}
	
	public static void creationGrue(String stringGrue, Magasin m1) {
		String params[] = stringGrue.split(",");
		Grue grue = new Grue(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(grue);
	}
	
	public static void creationVentouse(String stringVentouse, Magasin m1) {
		String params[] = stringVentouse.split(",");
		Ventouse ventouse = new Ventouse(params[0], params[1], params[2], Double.parseDouble(params[3]), 
				Integer.valueOf(params[4]), Double.parseDouble(params[4]));
		m1.ajoutArticle(ventouse);
	}
	
	public static void creationNouveauClient(Magasin m1) {
		boolean breakMain2 = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(breakMain2) {
			System.out.println("\n==================================================================================");
			System.out.println("|   Nouveau client                                                               |");
			System.out.println("==================================================================================");
			System.out.println("Saisissez le nom et l'adresse du client."
					+ "\nPour rappel, il faut saisir toutes les options en \nles séparants"
					+ " par une virgule ! Note : il faut coller les virgules sans mettre d'espaces.\n"
					+ "Exemple : expression avec espace,expression,expression avec espace\n"
					+ "Tapez retour pour retourner en arrière.");
			
			String stringClient = "";
			try {
				stringClient = br.readLine();
				if (stringClient.equals("retour")) {
					// Retour menu principal
					breakMain2 = false;
				}
				else {
					String params[] = stringClient.split(",");
					Client c = new Client(params[0],params[1]);
					m1.ajoutClient(c);
					System.out.println("Le client a bien été rajouté au magasin !");
					System.out.println(c);
					// Retour menu principal
					breakMain2  = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	public static void creationLocation(Magasin m1) {
		boolean breakMain2 = true;
		int refClient = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(breakMain2) {
			System.out.println("\n==================================================================================");
			System.out.println("|   Nouvelle location                                                            |");
			System.out.println("==================================================================================");
			System.out.println("Choisissez un client en rentrant sa référence : ");
			// Affiche la liste des clients
			for (Client c : m1.getListeClients()) {
				System.out.println(c);
			}
			try{
				refClient = Integer.valueOf(br.readLine());
			}
			catch (IOException e) {
				System.out.println("Veuillez entrer une option correcte.");
			}
			
			// Récupération du client avec la référence saisie par l'utilisateur
			Client clientLocation = m1.getClientByRef(refClient);
			
			// On vérifie que le client existe bien dans le magasin avant de continuer
			if(clientLocation != null) {
				String stringArticle = "";
				System.out.println("Selectionnez un ou plusieurs articles par sa référence : ");
				System.out.println("Séparer les articles par une virgule sans espaces ! Exemple : article1,article2\n\n");
				// Affichage des articles disponibles à la location
				for (Article a : m1.getArticles()) {
					System.out.println(a);
				}
				try{
					stringArticle = br.readLine();
				}
				catch (IOException e) {
					System.out.println("Veuillez entrer une option correcte.");
				}
				
				// Récupération des articles avec les références saisies par l'utilisateur
				ArrayList<Article> articlesLocation = new ArrayList<Article>();
				String articles[] = stringArticle.split(",");
				for (String refArticle : articles) {
					articlesLocation.addAll(m1.getArticleByRef(refArticle));
				}
				
				// Si il y a des articles à louer on continue la location
				if(!articlesLocation.isEmpty()) {
					String stringDureeLocation = "";
					System.out.println("Saisissez la durée de la location sous la forme nombreDeJours,nombreDeMois,nombreD'années\n"
							+ "Exemple : 10,3,0 pour une location de 10 jours et trois mois.");
					try{
						stringDureeLocation = br.readLine();						
					}
					catch (IOException e) {
						System.out.println("Veuillez entrer une option correcte.");
					}
					
					String dureeLocation[] = stringDureeLocation.split(",");
					// On fait ensuite la location au niveau du magasin
					Location loc = m1.locationPeriodique(clientLocation, articlesLocation, Integer.valueOf(dureeLocation[2]), Integer.valueOf(dureeLocation[1]),
							Integer.valueOf(dureeLocation[0]));

					System.out.println("La location a bien été ajoutée !");
					System.out.println("Montant à facturer au client : " + loc.getMontantAFacturer() + "€");
					// On revient dans le menu principal
					breakMain2 = false;
				}
				else {
					System.out.println("Il n'y a aucun article à louer, impossible de continuer la location !");
				}
			}
			else {
				System.out.println("Veuillez selectionner un client existant !");
			}
		}
	}
	
	public static void menuPrincipal() {
		System.out.println("\n==================================================================================");
		System.out.println("|   MENU PRINCIPAL                                                               |");
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
