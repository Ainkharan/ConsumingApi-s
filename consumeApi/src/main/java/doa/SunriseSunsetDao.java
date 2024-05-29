package doa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Result;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SunriseSunsetDao {

    private static final String BASE_URL = "https://api.sunrisesunset.io/json";

    public static Result getSunriseSunset(String longitude, String latitude) throws JsonProcessingException {

        HttpResponse<String> response = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL+ "?lat=" +latitude+ "&lng="+longitude))
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
           // System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mapper.readValue(response.body(), Result.class);

    }
}
