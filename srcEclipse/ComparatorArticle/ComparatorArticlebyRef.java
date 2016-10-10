package ComparatorArticle;

import java.util.Comparator;

import main.Article;

public class ComparatorArticlebyRef implements Comparator<Article>{

	@Override
	public int compare(Article art1, Article art2) {
		return art1.getReference().compareTo(art2.getReference());
	}

	
}
