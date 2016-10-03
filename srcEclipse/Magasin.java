import java.util.ArrayList;
import java.util.Iterator;

public class Magasin {
	private String nom;
	private ArrayList<Client> listeClients;
	private ArrayList<Article> articles;
	
	public Magasin(String nom) {
		this.nom = nom;
		this.listeClients = new ArrayList<Client>();
		this.articles = new ArrayList<Article>();
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}
	
	public ArrayList<Article> getArticlesLouesByRef(String reference) {
	    Iterator itr = articles.iterator();
	    ArrayList<Article> artReturned = new ArrayList<Article>();
	    while(itr.hasNext()) {
	    	Article art = (Article) itr.next();
	    	if(art.getReference() == reference) {
	    		artReturned.add(art);
	    	}	    	
	    }
		return artReturned;
	}
	
	public ArrayList<Article> getArticlesLouesByMarque(String marque) {
		Iterator itr = articles.iterator();
	    ArrayList<Article> artReturned = new ArrayList<Article>();
	    while(itr.hasNext()) {
	    	Article art = (Article) itr.next();
	    	if(art.getMarque() == marque) {
	    		artReturned.add(art);
	    	}	    	
	    }
		return artReturned;
	}
	
	public ArrayList<Article> getArticlesLouesByNom(String nom) {
		Iterator itr = articles.iterator();
	    ArrayList<Article> artReturned = new ArrayList<Article>();
	    while(itr.hasNext()) {
	    	Article art = (Article) itr.next();
	    	if(art.getNom() == nom) {
	    		artReturned.add(art);
	    	}	    	
	    }
		return artReturned;
	}
	
	public ArrayList<Article> getArticlesLouesByPrix(float prixParJour) {
		Iterator itr = articles.iterator();
	    ArrayList<Article> artReturned = new ArrayList<Article>();
	    while(itr.hasNext()) {
	    	Article art = (Article) itr.next();
	    	if(art.getPrixLocationParJour() == prixParJour) {
	    		artReturned.add(art);
	    	}	    	
	    }
		return artReturned;
	}
	
	public Location louer(Client client, ArrayList<Article> articles){
		Location location = new Location();
		return null;
	}
}
