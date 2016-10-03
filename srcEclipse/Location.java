import java.util.ArrayList;
import java.util.Calendar;

public class Location {
	private Calendar dateDebut;
	private Calendar dateFin;
	private ArrayList<Article> articles;
	private Client client;
	
	public Location(Client client, ArrayList<Article> articles) {
		Calendar cal = Calendar.getInstance();
		this.dateDebut = cal.set(year, month, date);;
	}
}
