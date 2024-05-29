package BookDao;

import BookModel.BooksResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FakeBooksDAO {

    public static final String BASE_URL = "https://fakerapi.it/api/v1/credit_cards";

    public static BooksResult getBooks(String quantity, String local) throws JsonProcessingException {

        HttpResponse<String> response = null;
        ObjectMapper mapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI( BASE_URL+ "?_quantity=" +quantity+ "&_locale=" +local ))
                    .GET()
                    .build();
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mapper.readValue(response.body(), BooksResult.class);
    }
}
