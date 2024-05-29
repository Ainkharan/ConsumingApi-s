package doa;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {

        try {
            var response = SunriseSunsetDao.getSunriseSunset("51.1324" ,"0.2637");
            System.out.println(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}