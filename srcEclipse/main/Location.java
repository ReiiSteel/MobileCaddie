package main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import Acquisition.Camera;
import Acquisition.Objectif;

public class Location {
	private GregorianCalendar dateDebut;
	private GregorianCalendar dateFin;
	private ArrayList<Article> articles;
	private Client client;
	
	/**
	 * Constructeur de la class Location
	 * @param client : client qui fait la location
	 * @param articles : articles loues par le client
	 * @param year : nombre d'annees de location
	 * @param month : nombre de mois de location
	 * @param day : nombre de jours de location
	 */
	public Location(Client client, ArrayList<Article> articles, int nbYear, int nbMonth, int nbDay) {
		if (nbDay > 0) {
			this.articles = new ArrayList<Article>();
			this.dateDebut = new GregorianCalendar();
			this.client = client;
			this.articles.addAll(articles);
			this.dateFin = (GregorianCalendar) this.dateDebut.clone();
			this.dateFin.add(Calendar.YEAR, nbYear);
			this.dateFin.add(Calendar.MONTH, nbMonth);
			this.dateFin.add(Calendar.DATE, nbDay);	
		}
		else System.out.println("Impossible de faire une location qui dure 0 jour !");
	}
	
	/**
	 * Constructeur de la class Location
	 * @param client : client qui fait la location
	 * @param articles : articles loues par le client
	 * @param yearDeb : année de début de location
	 * @param monthDeb : mois de début de location
	 * @param dayDeb : jour de début de location
	 * @param yearFin : année de fin de location
	 * @param monthFin : mois de fin de location
	 * @param dayFin : jour de fin de location
	 */
	public Location(Client client, ArrayList<Article> articles, int dayDeb, int monthDeb, int yearDeb, int dayFin, int monthFin, int yearFin) {
		// TODO VERIF date
		if(yearDeb <= yearFin){
			if(monthDeb <= monthFin){
				if(dayDeb < dayFin){
					this.articles = new ArrayList<Article>();
					this.dateDebut = new GregorianCalendar();
					this.dateDebut.set(Calendar.YEAR, yearDeb);
					this.dateDebut.set(Calendar.MONTH, monthDeb);
					this.dateDebut.set(Calendar.DATE, dayDeb);
					this.client = client;
					this.articles.addAll(articles);
					this.dateFin = new GregorianCalendar();
					this.dateFin.set(Calendar.YEAR, yearFin);
					this.dateFin.set(Calendar.MONTH, monthFin);
					this.dateFin.set(Calendar.DATE, dayFin);
				}
			}
		}
		else {
			System.out.println("Date de début et de fin incohérente");
		}
	}
	
	/**
	 * Donne le montant a facturer sur la période complete
	 * @return : montant a facturer
	 */
	public double getMontantAFacturer(){
		return this.getMontantPeriodefromStart(this.dateFin);
	}
	
	/**
	 * Donne le montant de la location sur une periode donnee à partir du début de la location
	 * @param finPeriode : Object GregorianCalendar correspondant à la fin de la periode
	 * @return Le montant de la location sur une periode donnee
	 */
	public double getMontantPeriodefromStart(GregorianCalendar finPeriode){
		return getMontantPeriode(this.dateDebut, finPeriode);
	}
	
	/**
	 * Donne le montant de la location sur une periode donnee
	 * @param debutPeriode : Object GregorianCalendar correspondant au début de la periode
	 * @param finPeriode : Object GregorianCalendar correspondant à la fin de la periode
	 * @return Le montant de la location sur une periode donnee
	 */
	public double getMontantPeriode(GregorianCalendar debutPeriode, GregorianCalendar finPeriode){
		//Initialisation
		double montant = 0.0;
		
		if(debutPeriode.compareTo(this.dateDebut) == -1){
			debutPeriode = this.dateDebut;
		}
		if(finPeriode.compareTo(this.dateFin) == 1){
			finPeriode = this.dateFin;
		}
	
		int nbJours = 0;
		int actualYear = debutPeriode.get(Calendar.YEAR);
		
		//Traitement
		if( actualYear == finPeriode.get(Calendar.YEAR)){
			nbJours = finPeriode.get(Calendar.DAY_OF_YEAR) - debutPeriode.get(Calendar.DAY_OF_YEAR);
		}
		else{
			if(actualYear%4==0 && actualYear%100==0 && actualYear%400==0){
				nbJours += 366-debutPeriode.get(Calendar.DAY_OF_YEAR);
			}
			else{
				nbJours += 365-debutPeriode.get(Calendar.DAY_OF_YEAR);
			}
			for (int i = actualYear+1; i < finPeriode.get(Calendar.YEAR) ; i++) {
				if(actualYear%4==0 && actualYear%100==0 && actualYear%400==0){
					nbJours += 366;
				}
				else{
					nbJours += 365;
				}
			}
			nbJours += finPeriode.get(Calendar.DAY_OF_YEAR);
		}
		
		for ( Article article : this.articles) {
			montant += article.getPrixLocationParJour()*nbJours;
		}
		return montant;
	}
	
	/**
	 * Permet de savoir si une location est terminee
	 * @return
	 */
	public boolean isEnd(){
		GregorianCalendar gcal = new GregorianCalendar();
		if(gcal.get(Calendar.YEAR) >= this.dateFin.get(Calendar.YEAR)){
			if(gcal.get(Calendar.MONTH) >= this.dateFin.get(Calendar.MONTH)){
				if(gcal.get(Calendar.DATE) >= this.dateFin.get(Calendar.DATE)){
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public GregorianCalendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(GregorianCalendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	public GregorianCalendar getDateFin() {
		return dateFin;
	}

	public void setDateFin(GregorianCalendar dateFin) {
		this.dateFin = dateFin;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String toString() {
		return ("Location concernant le client " + this.client.toString() + ".\n" +
				"Elle commence le " + this.getDateDebut().get(Calendar.DATE) + "/" + 
				this.getDateDebut().get(Calendar.MONTH) + "/" + this.getDateDebut().get(Calendar.YEAR)+ " et termine le " + 
				this.getDateFin().get(Calendar.DATE) + "/" + this.getDateFin().get(Calendar.MONTH) + "/" + this.getDateFin().get(Calendar.YEAR) + ".\n" +
				"Article(s) loué(s) : " + this.getArticles().toString() + "\n");		
	}
}
