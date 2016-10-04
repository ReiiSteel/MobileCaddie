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
		GregorianCalendar datedebut = new GregorianCalendar();
		this.dateDebut = datedebut;
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
		int nbAnnees = this.dateFin.get(Calendar.YEAR) - this.dateDebut.get(Calendar.YEAR);
		int moisActu = this.dateDebut.get(Calendar.DAY_OF_MONTH);
		int nbMois = this.dateFin.get(Calendar.MONTH) - this.dateDebut.get(Calendar.MONTH);
		int nbJours = this.dateFin.get(Calendar.DATE) - this.dateDebut.get(Calendar.DATE) + nbMois;
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
