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
		return this.getMontantPeriode(this.dateFin);
	}
	
	
	public float getMontantPeriode(GregorianCalendar gcal){
		
		float montant = 0.0f;
		
		int nbJours = 0;
		int jourActu = this.dateDebut.get(Calendar.DATE);
		int nbMois = gcal.get(Calendar.MONTH) - this.dateDebut.get(Calendar.MONTH);
		int moisActu = gcal.get(Calendar.MONTH);
		int nbAnnees = gcal.get(Calendar.YEAR) - this.dateDebut.get(Calendar.YEAR);
		int anneeActu = this.dateDebut.get(Calendar.YEAR);
		
		if(moisActu == 1){
			if(anneeActu%4==0 && anneeActu%100==0 && anneeActu%400==0){
				nbJours = 29-jourActu;
			}
			else{
				nbJours = 28-jourActu;
			}
		}
		else if(moisActu<6 && moisActu%2==0){
			nbJours = 31-jourActu;
		}
		else if(moisActu<6 && moisActu%2!=0){
			nbJours = 30-jourActu;
		}
		else if(moisActu==6){
			nbJours = 31-jourActu;
		}
		else if(moisActu>6 && moisActu%2==0){
			nbJours = 30-jourActu;
		}
		else if(moisActu>6 && moisActu%2!=0){
			nbJours = 31-jourActu;
		}
		
		int mois = moisActu+1;
		for (int i = 0; i < nbMois; i++) {
			if(mois == 1){
				if(anneeActu%4==0 && anneeActu%100==0 && anneeActu%400==0){
					nbJours += 29;
				}
				else{
					nbJours += 28;
				}
			}
			else if(mois<6 && mois%2==0){
				nbJours += 31;
			}
			else if(mois<6 && mois%2!=0){
				nbJours += 30;
			}
			else if(mois==6){
				nbJours += 31;
			}
			else if(mois>6 && mois%2==0){
				nbJours += 30;
			}
			else if(mois>6 && mois%2!=0){
				nbJours += 31;
			}
			mois++;
		}
		
		int annee = anneeActu;
		for (int i = 0; i < nbAnnees; i++) {
			if(annee%4==0 && annee%100==0 && annee%400==0){
				nbJours += 366;
			}
			else{
				nbJours += 365;
			}
			annee++;
		}
		
		for ( Article article : this.articles) {
			montant += article.getPrixLocationParJour()*nbJours;
		}
		return montant;
	}
	
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
