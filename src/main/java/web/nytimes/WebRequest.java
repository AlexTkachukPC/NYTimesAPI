package web.nytimes;

public class WebRequest {


    public static void main(String[] args) {
        ArticleSearchService ass = new ArticleSearchService();
        System.out.println(ass.getArticles());
    }
}
