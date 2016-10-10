package ComparatorArticle;

import java.util.Comparator;

import main.Article;

public class ComparatorArticlebyPrix implements Comparator<Article>{

	@Override
	public int compare(Article art1, Article art2) {
		return Double.compare(art1.getPrixLocationParJour(), art2.getPrixLocationParJour());
	}
	
}
