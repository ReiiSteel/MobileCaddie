package main;

import java.io.IOException;
import java.util.ArrayList;

import Acquisition.Camera;
import Acquisition.Objectif;

public class Main {
	
	public static void main(String[] args) {
		Magasin m1 = new Magasin("yo");
		Client c1 = new Client("Nom", "Nantes");
		Objectif obj = new Objectif("Nom", "ref", "modele", 5, 1, "type obj", 99442, "1920*1080");
		Camera cam = new Camera("Nom", "ref2", "modele", 2.5f, 1, "type obj", 999999, "1920*1080");
		ArrayList<Article> arts = new ArrayList<Article>();
		arts.add(obj);
		arts.add(cam);
		
		m1.louer(c1, arts, 2020, 10, 20);
		try {
			m1.archive();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
