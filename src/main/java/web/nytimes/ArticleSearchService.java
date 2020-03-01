package web.nytimes;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ArticleSearchService {
    private static final String KEY = "dAjJ3BAAP22om5GfsmrNbF19iwK9e1SO";

    private final RestTemplate restTemplate;

    public ArticleSearchService() {
        this.restTemplate = getRestTemplate();
    }

    private RestTemplate getRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {



            HttpHeaders headers = request.getHeaders();
            headers.add("API-KEY", KEY);

            return execution.execute(request, body);
        });
        return restTemplate;
    }

    public String getArticles() {
        String url = "https://api.nytimes.com/svc/search/v2/articlesearch.json";

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpHeaders jsonBodyHeaders = new HttpHeaders();
        jsonBodyHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }
}
