package SunriseSunsetdao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import SunriseSunsetmodel.SunriseSunsetResults;
import SunriseSunsetmodel.SunriseSunset;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SunriseSunsetDao {

    private static final String BASE_URL = "https://api.sunrisesunset.io/json";

    public static SunriseSunsetResults getSunriseSunset(String latitude, String longitude) throws JsonProcessingException {

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
            throw new RuntimeException();
        }
        System.out.println(mapper.readValue(response.body(), SunriseSunset.class));
        return mapper.readValue(response.body(), SunriseSunsetResults.class);

    }
}
