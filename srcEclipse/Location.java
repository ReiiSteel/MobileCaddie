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
	 * @param year
	 * @param month
	 * @param day
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
	 * @return : 
	 */
	public float getMontantAFacturer(){
		float montant = 0.0f;
		for ( Article article : this.articles) {
			montant += article.getPrixLocationParJour()*(this.dateDebut.get(2));
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
