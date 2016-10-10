package ComparatorArticle;

import java.util.Comparator;

import main.Article;

public class ComparatorArticlebyMarque implements Comparator<Article>{

	@Override
	public int compare(Article art1, Article art2) {
		return art1.getMarque().compareTo(art2.getMarque());
	}

}
