package ComparatorArticle;

import java.util.Comparator;

import main.Article;

public class ComparatorArticlebyNom implements Comparator<Article>{

	@Override
	public int compare(Article art1, Article art2) {
		return art1.getNom().compareTo(art2.getNom());
	}

}
