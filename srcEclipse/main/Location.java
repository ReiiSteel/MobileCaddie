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
	public Location(Client client, ArrayList<Article> articles, int nbYear, int nbMonth, int nbDay) {
		this.articles = new ArrayList<Article>();
		this.dateDebut = new GregorianCalendar();
		this.client = client;
		this.articles.addAll(articles);
		this.dateFin = (GregorianCalendar) this.dateDebut.clone();
		this.dateFin.add(Calendar.YEAR, nbYear);
		this.dateFin.add(Calendar.MONTH, nbMonth);
		this.dateFin.add(Calendar.DATE, nbDay);
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
				if(dayDeb<dayFin){
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
			System.out.println("nul");
		}
	}
	
	/**
	 * Donne le montant a facturer sur la période complete
	 * @return : montant a facturer
	 */
	public float getMontantAFacturer(){
		return this.getMontantPeriode(this.dateFin);
	}
	
	/**
	 * Donne le montant de la location sur une periode donnee
	 * @param finPeriode : Object GregorianCalendar correspondant à la fin de la periode
	 * @return Le montant de la location sur une periode donnee
	 */
	public float getMontantPeriode(GregorianCalendar finPeriode){
		// TODO ne fonctionne pas
		//Initialisation
		float montant = 0.0f;
		
		int nbJours = 0;
		int jourActu = this.dateDebut.get(Calendar.DATE);
		int nbMois = finPeriode.get(Calendar.MONTH) - this.dateDebut.get(Calendar.MONTH);
		int moisActu = finPeriode.get(Calendar.MONTH);
		int nbAnnees = finPeriode.get(Calendar.YEAR) - this.dateDebut.get(Calendar.YEAR);
		int anneeActu = this.dateDebut.get(Calendar.YEAR);
		
		//Ajout nombre de jours
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
		
		//Ajout nombre de jours par mois
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
		
		//Ajout nombre de jours par annee
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
				"Elle commence le " + this.getDateDebut().get(Calendar.DATE) + " et termine le " + this.getDateFin().get(Calendar.DATE) + ".\n" +
				"Article(s) loué(s) : " + this.getArticles().toString() + "\n");		
	}
}
