package main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
	public Location(Client client, ArrayList<Article> articles, int year, int month, int day) {
		this.articles = new ArrayList<Article>();
		this.dateDebut = new GregorianCalendar();
		this.client = client;
		this.articles.addAll(articles);
		this.dateFin = (GregorianCalendar) this.dateDebut.clone();
		this.dateFin.add(Calendar.YEAR, year);
		this.dateFin.add(Calendar.MONTH, month);
		this.dateFin.add(Calendar.DATE, day);
	}
	
	/**
	 * Donne le montant a facturer sur la période complete
	 * @return : montant a facturer
	 */
	public float getMontantAFacturer(){
		float montant = 0.0f;
		int nbJours = this.dateFin.get(Calendar.DATE) - this.dateDebut.get(Calendar.DATE);
		int nbMois = this.dateFin.get(Calendar.MONTH) - this.dateDebut.get(Calendar.MONTH);
		int moisActu = this.dateDebut.get(Calendar.MONTH);
		int nbAnnees = this.dateFin.get(Calendar.YEAR) - this.dateDebut.get(Calendar.YEAR);
		int anneeActu = this.dateDebut.get(Calendar.YEAR);
		if(moisActu == 1){
			if(anneeActu%4==0 && anneeActu%100==0 && anneeActu%400==0){
				//nbJours
				System.out.println("29 jours");
			}
			else{
				System.out.println("28 jours");
			}
		}
		else if(moisActu<6 && moisActu%2==0){
			System.out.println("31 jours");
		}
		else if(moisActu<6 && moisActu%2!=0){
			System.out.println("30 jours");
		}
		else if(moisActu==6){
			System.out.println("31 jours");
		}
		else if(moisActu>6 && moisActu%2==0){
			System.out.println("30 jours");
		}
		else if(moisActu>6 && moisActu%2!=0){
			System.out.println("31 jours");
		}
		for ( Article article : this.articles) {
			montant += article.getPrixLocationParJour();
		}
		return montant;
	}
	
	
	//public float getMontantPeriode()
	
	//end loc retire client

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
}
