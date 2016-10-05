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
		Objectif obj = new Objectif("Nom", "ref", "modele", 5, 4, "type obj", 99442, "1920*1080");
		Camera cam = new Camera("Nom", "ref2", "modele", 2.5f, 4, "type obj", 999999, "1920*1080");
		m1.ajoutArticle(obj);
		m1.ajoutArticle(obj);
		ArrayList<Article> arts = new ArrayList<Article>();
		arts.add(obj);
		arts.add(cam);

		Location loc = m1.louer(c1, arts, 0, 0, 20);
		Location loc2 = m1.louer(c2, arts, 0, 0, 1);
		System.out.println("Montant : " + loc.getMontantAFacturer());
		System.out.println("Bonne location : \n" + loc.toString());
		System.out.println("Bonne location2 : \n" + loc2.toString());
		try {
			m1.archive();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			m1.memLocEnCours();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
