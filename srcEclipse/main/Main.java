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

		/*Location loc = m1.locationPeriodique(c1, arts, 0, 0, 20);
		Location loc2 = m1.locationPeriodique(c2, arts, 0, 0, 2);*/
		
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
	}
}
